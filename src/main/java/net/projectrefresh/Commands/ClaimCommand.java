package net.projectrefresh.Commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
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
            ItemManager.latestItem.claim(event.getAuthor(), event.getChannel());
        }
    }
}
