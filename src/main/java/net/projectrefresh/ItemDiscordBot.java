package net.projectrefresh;

import lombok.Getter;
import lombok.SneakyThrows;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.projectrefresh.Commands.*;
import net.projectrefresh.Database.Redis;
import net.projectrefresh.Items.ItemManager;
import net.projectrefresh.Listeners.ChannelListener;
import net.projectrefresh.Listeners.CommandListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class ItemDiscordBot {

    public static JDA jda;
    @Getter
    private static Properties properties;

    @Getter
    private static ItemManager itemManager;

    @SneakyThrows
    public static void main(String[] args) {
        properties = new Properties();
        File settings = new File("settings.conf");
        if (!settings.exists()) {
            properties.setProperty("discord-token", "changeme");
            properties.setProperty("redis-host", "0.0.0.0");
            properties.setProperty("redis-port", "6379");
            properties.setProperty("redis-password", "changeme");
            properties.setProperty("listen-channel", "Channel ID");
            properties.store(new FileOutputStream(settings), "Item Bot Configuration");
            System.out.println("Settings Saved. Please edit and start again.");
            System.exit(0);
        } else {
            properties.load(new FileInputStream(settings));
        }

        String host = properties.getProperty("redis-host");
        int port = Integer.parseInt(ItemDiscordBot.getProperties().getProperty("redis-port"));
        String password = properties.getProperty("redis-password");
        new Redis(host, port, password);
        itemManager = new ItemManager();

        jda = JDABuilder.createLight(properties.getProperty("discord-token"))
                .setActivity(Activity.playing("with ghosts. Commands h!help"))
                .setAutoReconnect(true)
                .setStatus(OnlineStatus.ONLINE)
                .addEventListeners(new CommandListener())
                .addEventListeners(new ChannelListener())
                .build();

        //Register Commands
        new TestCommand();
        new ClaimCommand();
        new LeaderboardCommand();
        new InventoryCommand();
        new SummonCommand();
        new HelpCommand();
        new PermissionCommand();
    }
}
