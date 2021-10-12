package net.projectrefresh.Commands;

import java.util.HashMap;
import java.util.Optional;

public class CommandMap {

    private static final HashMap<String, Optional<CoreCommand>> commands = new HashMap<>();

    public static void addCommand(String command, CoreCommand cmdclass){
        commands.put(command, Optional.ofNullable(cmdclass));
        System.out.println("Registered Command: " + command );
    }

    public static CoreCommand getCommand(String string){
        if (commands.containsKey(string)){
            return commands.get(string).get();
        }
        else {
            return null;
        }
    }


}
