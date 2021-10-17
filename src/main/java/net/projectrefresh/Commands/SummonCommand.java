package net.projectrefresh.Commands;

import lombok.SneakyThrows;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.projectrefresh.Database.Redis;
import net.projectrefresh.ItemDiscordBot;
import net.projectrefresh.Items.ItemManager;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class SummonCommand extends CoreCommand {
    public SummonCommand() {
        super("summon", "Summon a Random Item");
    }

    @SneakyThrows
    @Override
    public void execute(@NotNull MessageReceivedEvent event, String... args) {
        if (Redis.getPermissionLevel(event.getGuild().getId(), event.getAuthor().getId()) == 4) {
            CompletableFuture<Message> msg = event.getChannel().sendMessageEmbeds(ItemDiscordBot.getItemManager().spawnItem(event.getChannel().getId())).submit();
            ItemDiscordBot.getItemManager().getChannelItem(event.getChannel().getId()).setMsgid(msg.get().getId());
        }
        else {
            event.getChannel().sendMessage("Sorry. You don't have permission to this command.").submit();
        }
    }
}
