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
        if (Redis.getPermissionLevel(event.getAuthor().getId()) == 4) {
            TextChannel channel = ItemDiscordBot.jda.getTextChannelById("888136777381085264");
            EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle("Item Bot Admin");
            builder.setDescription("All current Items that are running over the channels.");
            for (String channelid : ItemDiscordBot.getItemManager().getChannelActiveItems().keySet()){
                builder.addField(ItemDiscordBot.jda.getTextChannelById(channelid).getName(), ItemDiscordBot.getItemManager().getChannelItem(channelid).getItem().getLable(), false);
            }
            channel.sendMessageEmbeds(builder.build()).submit();
        }
    }
}
