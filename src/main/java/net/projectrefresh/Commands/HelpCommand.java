package net.projectrefresh.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Optional;

public class HelpCommand extends CoreCommand {
    public HelpCommand() {
        super("help", "Help Command. Everything you need to know.");
    }

    //TODO Need help with removing dupes or manually making.
    @Override
    public void execute(@NotNull MessageReceivedEvent event, String... args) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setColor(Color.green);
        builder.setTitle("Item Bot Help Guide");
        builder.setDescription("Have a look at all the commands and how to use them");
        builder.setThumbnail("https://cdn.discordapp.com/halloween-bot/Nice-Pumpkins.png");
        for (Optional<CoreCommand> command : CommandMap.getAllCommands()) {
            builder.addField(command.get().getLabel(), command.get().getDescription(), false);
        }
        builder.setFooter("Extended help please check GitHub or as Ca33r0n1");
        event.getChannel().sendMessageEmbeds(builder.build()).submit();
    }
}