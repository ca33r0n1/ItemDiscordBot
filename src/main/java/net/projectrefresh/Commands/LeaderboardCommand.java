package net.projectrefresh.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.projectrefresh.Database.Redis;
import net.projectrefresh.ItemDiscordBot;
import net.projectrefresh.Utils;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LeaderboardCommand extends CoreCommand {

    public LeaderboardCommand() {
        super("leaderboard", "The top scores", "top", "highscore");
    }

    @Override
    public void execute(@NotNull MessageReceivedEvent event, String... args) {
        Map<String, String> keys = Redis.getJedis().hgetAll(event.getGuild().getId());
        HashMap<String, Integer> temp = new HashMap<>();
        for (String discordid : keys.keySet()) {
            JSONObject object = new JSONObject(keys.get(discordid));
            Integer claims = object.getInt("total_claims");
            temp.put(discordid, claims);
        }
        HashMap<String, Integer> leaderboard = Utils.sortByHigh(temp);
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Happy Halloween - Current Leaderboard");
        builder.setDescription("The current scores for all the users!");

        for (String user : leaderboard.keySet()) {
            User u = ItemDiscordBot.jda.retrieveUserById(user).complete();
            builder.addField(u.getName(), "Total Items: " + leaderboard.get(user), false);
        }
        builder.setThumbnail("https://cdn.discordapp.com/halloween-bot/Nice-Pumpkins.png");
        builder.setFooter("Thank you discord for the Idea and Images. Developed by Ca33r0n1");
        event.getChannel().sendMessageEmbeds(builder.build()).submit();
    }


}
