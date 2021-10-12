package net.projectrefresh.Commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

public class TestCommand extends CoreCommand{
    public TestCommand() {
        super("test", "This is a test command. It is aimed at proof of concept that the command manager works!");
    }

    @Override
    public void execute(@NotNull MessageReceivedEvent event) {
        event.getChannel().sendMessage("Hurray! The test command works!").submit();
    }
}
