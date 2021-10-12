package net.projectrefresh.Commands;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.projectrefresh.Database.Redis;
import net.projectrefresh.ItemDiscordBot;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutionException;

public class PermissionCommand extends CoreCommand{

    public PermissionCommand() {
        super("permissions", "Make changes to the permissions the that bot uses.", "perms", "access");
    }

    @Override
    public void execute(@NotNull MessageReceivedEvent event, String... args) {
        if (Redis.getPermissionLevel(event.getAuthor().getId()) != 4){
            event.getChannel().sendMessage("You do not have permission ot this command. Please contact a Mod if this is an error.").submit();
            return;
        }
        switch (args[0]){
            case "add":
            case "set":
            case "give": {
                Redis.setPermissionLevel(args[1], Integer.valueOf(args[2]));
                User user;
                try{
                    user = ItemDiscordBot.jda.retrieveUserById(args[1]).submit().get();
                    event.getChannel().sendMessage(user.getName() + " has been given access to command that have a permission level of " + args[2]).submit();
                } catch (ExecutionException | InterruptedException e) {
                    System.out.println("Failed to get User by ID: " + args[1]);
                }
                break;
            }

            case "take":
            case "remove": {
                Redis.setPermissionLevel(args[1], 0);
                User user;
                try{
                    user = ItemDiscordBot.jda.retrieveUserById(args[1]).submit().get();
                    event.getChannel().sendMessage(user.getName() + "'s access has been set to 0").submit();
                } catch (ExecutionException | InterruptedException e) {
                    System.out.println("Failed to get User by ID: " + args[1]);
                }
                break;
            }

            default: {
                event.getChannel().sendMessage("Unknown Sub Command. Please try again.").submit();
                break;
            }
        }
    }
}
