package net.projectrefresh.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.projectrefresh.Database.Redis;
import net.projectrefresh.ItemDiscordBot;
import net.projectrefresh.Items.Item;
import org.jetbrains.annotations.NotNull;

public class ListActiveCommand  extends CoreCommand{
    public ListActiveCommand() {
        super("list", "List all treats active in all channels", "view");
    }

    @Override
    public void execute(@NotNull MessageReceivedEvent event, String... args) {
        if (Redis.getPermissionLevel(event.getGuild().getId(), event.getAuthor().getId()) == 4) {
            TextChannel channel = ItemDiscordBot.jda.getTextChannelById("888136777381085264");
            EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle("Item Bot Admin");
            builder.setDescription("All current Items that are running over the channels.");
            for (String channelid : ItemDiscordBot.getItemManager().getKeys()){
                Item item = ItemDiscordBot.getItemManager().getChannelItem(channelid);
                String claimed;
                if (item.getItem().isClaimed()){
                    claimed = "Claimed";
                }
                else {
                    claimed = "Not claimed yet!";
                }
                builder.addField(ItemDiscordBot.jda.getTextChannelById(channelid).getName(),
                      item.getItem().getLable() + " - " + claimed , false);
            }
            channel.sendMessageEmbeds(builder.build()).submit();
        }
    }
}
