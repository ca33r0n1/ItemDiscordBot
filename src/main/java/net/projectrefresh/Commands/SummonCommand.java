package net.projectrefresh.Commands;

import lombok.SneakyThrows;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.projectrefresh.Items.ItemManager;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class SummonCommand extends CoreCommand{
    public SummonCommand() {
        super("summon", "Summon a Random Item");
    }

    @SneakyThrows
    @Override
    public void execute(@NotNull MessageReceivedEvent event) {
        CompletableFuture<Message> msg = event.getChannel().sendMessageEmbeds(ItemManager.spawnItem()).submit();
        ItemManager.latestItem.setMsgid(msg.get().getId());
    }
}
