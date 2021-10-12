package net.projectrefresh.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.projectrefresh.Database.Redis;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.awt.*;

public class InventoryCommand extends CoreCommand{
    public InventoryCommand() {
        super("inventory", "Get your item Inventory", "inv", "items");
    }

    @Override
    public void execute(@NotNull MessageReceivedEvent event, String... args) {
        if(!event.getAuthor().isBot()) {
            User user = event.getAuthor();
            JSONObject object = Redis.getInv(user.getId());
            EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle("Happy Halloween - " + user.getAsTag() + " Inventory");
            builder.setDescription("All the items in your inventory!");
            if (object == null) {
                builder.addField("No Items in your Inventory", "Have fun trying to answer the trick or treaters", false);
            } else {
                for (String key : object.keySet()) {
                    if (!key.equalsIgnoreCase("total_claims")) {
                        builder.addField(key + " x" + object.getInt(key), "", false);
                    }
                }
            }
            builder.setColor(Color.orange);
            builder.setThumbnail("https://cdn.discordapp.com/halloween-bot/Nice-Pumpkins.png");
            builder.setFooter("Thank you discord for the Idea and Images. Developed by Ca33r0n1");
            event.getChannel().sendMessageEmbeds(builder.build()).submit();
        }
    }
}
