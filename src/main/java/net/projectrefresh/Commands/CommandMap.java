package net.projectrefresh.Commands;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

public class CommandMap {

    private static final HashMap<String, Optional<CoreCommand>> commands = new HashMap<>();

    public static void addCommand(String command, CoreCommand cmdclass) {
        commands.put(command, Optional.ofNullable(cmdclass));
        System.out.println("Registered Command: " + command);
    }

    public static CoreCommand getCommand(String string) {
        if (commands.containsKey(string)) {
            return commands.get(string).get();
        } else {
            return null;
        }
    }

    public static boolean contains(String command) {
        return commands.containsKey(command);
    }

    public static Collection<Optional<CoreCommand>> getAllCommands() {
        return commands.values();
    }


}
