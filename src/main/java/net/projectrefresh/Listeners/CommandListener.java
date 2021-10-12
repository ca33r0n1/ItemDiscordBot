package net.projectrefresh.Listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.projectrefresh.Commands.CommandMap;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Objects;

public class CommandListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (!event.getAuthor().isBot()) {
            //System.out.println("[DEBUG] Stripped Message: " + event.getMessage().getContentStripped());
            if (event.getMessage().getContentStripped().toLowerCase(Locale.ROOT).startsWith("h!")) {
                String[] command = event.getMessage().getContentStripped().toLowerCase(Locale.ROOT).split("h!");
                if (command[1] == null) {
                    event.getChannel().sendMessage("Unknown Command. Please use h!help to get a list of commands.").submit();
                } else {
                    Objects.requireNonNull(CommandMap.getCommand(command[1])).execute(event);
                }
            }
        }
    }
}
