package net.projectrefresh.Commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.projectrefresh.Database.Redis;
import net.projectrefresh.ItemDiscordBot;
import org.jetbrains.annotations.NotNull;

public class ClaimCommand extends CoreCommand {
    public ClaimCommand() {
        super("claim", "Claim the item as your own and find out what it is.", "identify", "inspect");
    }

    /**
     * Pull the latest Item that's cached in the server and set it as claimed.
     */
    @Override
    public void execute(@NotNull MessageReceivedEvent event, String... args) {
        if (!event.getAuthor().isBot()) {
            if (Redis.getPermissionLevel(event.getGuild().getId(), event.getAuthor().getId()) == 4) {
                ItemDiscordBot.getItemManager().getChannelItem(event.getChannel().getId()).claim(event.getGuild().getId(), event.getAuthor(), event.getChannel());
            } else {
                event.getChannel().sendMessage("Sorry. No easy claims for you. <3").submit();
            }
        } else {
            ItemDiscordBot.getItemManager().getChannelItem(event.getChannel().getId()).claim(event.getGuild().getId(), event.getAuthor(), event.getChannel());
        }
    }
}
