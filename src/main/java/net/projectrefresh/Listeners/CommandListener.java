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
        String msg = event.getMessage().getContentStripped().toLowerCase(Locale.ROOT);
        if (!event.getAuthor().isBot()) {
            if (msg.toLowerCase(Locale.ROOT).startsWith("h!")) {
                String[] command = msg.split("h!");
                if (command.length == 0) {
                    event.getChannel().sendMessage("No command found. Please use h!help to get a list of commands.").submit();
                } else {
                    String[] cmdname = command[1].split(" ", 2);
                    if (cmdname.length != 0) {
                        Objects.requireNonNull(CommandMap.getCommand(cmdname[0])).execute(event);
                    } else {
                        String[] args = cmdname[1].split(" ");
                        if (!CommandMap.contains(cmdname[0])) {
                            event.getChannel().sendMessage("Unknown Command. Please use h!help to get a list of commands.").submit();
                        } else {
                            Objects.requireNonNull(CommandMap.getCommand(cmdname[0])).execute(event, args);
                        }
                    }
                }
            }
        }
    }
}
