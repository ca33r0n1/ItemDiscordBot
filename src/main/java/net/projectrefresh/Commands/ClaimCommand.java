package net.projectrefresh.Commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.projectrefresh.Database.Redis;
import net.projectrefresh.ItemDiscordBot;
import net.projectrefresh.Items.ItemManager;
import org.jetbrains.annotations.NotNull;

public class ClaimCommand extends CoreCommand {
    public ClaimCommand() {
        super("claim", "Claim the trick or treat from the spooky monsters", "trick", "treat");
    }


    /**
     * Pull the latest Item that's cached in the server and set it as claimed.
     */
    @Override
    public void execute(@NotNull MessageReceivedEvent event, String... args) {
        if (!event.getAuthor().isBot()) {
            if (event.getMessage().getContentStripped().equalsIgnoreCase("h!claim")){
                if (Redis.getPermissionLevel(event.getGuild().getId(), event.getAuthor().getId()) == 4){
                    ItemDiscordBot.getItemManager().getChannelItem(event.getChannel().getId()).claim(event.getGuild().getId(), event.getAuthor(), event.getChannel());
                    return;
                }
                else {
                    event.getChannel().sendMessage("Sorry. No easy claims for you. <3").submit();
                    return;
                }
            }
            ItemDiscordBot.getItemManager().getChannelItem(event.getChannel().getId()).claim(event.getGuild().getId(), event.getAuthor(), event.getChannel());
        }
    }
}
