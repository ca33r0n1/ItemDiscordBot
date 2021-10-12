package net.projectrefresh.Listeners;

import lombok.SneakyThrows;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.projectrefresh.ItemDiscordBot;
import net.projectrefresh.Items.ItemManager;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class ChannelListener extends ListenerAdapter {

    @SneakyThrows
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (!event.getAuthor().isBot()) {
            if (event.getChannel().getId().equals(ItemDiscordBot.getProperties().getProperty("listen-channel"))) {
                if (!event.getMessage().getContentStripped().startsWith("h!")) {
                    //We are in Halloween Channel.
                    Random r = new Random();
                    int game = r.nextInt(100);
                    System.out.println("This round was " + game);
                    if (game < 10) { // 10% Chance
                        CompletableFuture<Message> msg = event.getChannel().sendMessageEmbeds(ItemManager.spawnItem()).submit();
                        ItemManager.latestItem.setMsgid(msg.get().getId());
                    }
                }
            }
        }

    }
}
