package net.projectrefresh.Commands;

import lombok.Getter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

public class CoreCommand {

    @Getter
    private final String description;
    @Getter
    private String[] aliases;
    @Getter
    private final String label;

    /**
     * Construct a new command.
     *
     * @param command command label
     * @param description command description
     * @param aliases command aliases
     */
    public CoreCommand(String command, String description, String... aliases) {
        this.label = command;
        this.description = description;
        this.aliases = aliases;

        register();
    }
    /**
     * Construct a new command.
     *
     * @param command command label
     * @param description command description
     */
    public CoreCommand(String command, String description) {
        this.label = command;
        this.description = description;
        register();
    }

    /**
     *  Registers the command to the Command Map
     */
    private void register() {
        CommandMap.addCommand(label,this);
        if (aliases != null) {
            for (String S : aliases) {
                CommandMap.addCommand(S, this);
            }
        }
    }

    /**
     *  This is called to run the command. This method is what will run when a users passes a command.
     * @param event Message from Discord Channel
     */
    public void execute(@NotNull MessageReceivedEvent event, String... args){
    }

}
