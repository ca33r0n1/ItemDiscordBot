package net.projectrefresh.Items;

import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.projectrefresh.Database.Redis;
import net.projectrefresh.ItemDiscordBot;
import org.json.JSONObject;

public class Item {

    @Getter
    private final DnDItems item;
    @Getter
    private final EmbedBuilder message;

    @Setter
    @Getter
    private String msgid;


    public Item(DnDItems item, EmbedBuilder message) {
        this.item = item;
        this.message = message;
    }

    public void claim(String guildid, User user, MessageChannel channel) {
        if (!item.isClaimed()) {
            item.setClaimed(true);
            message.setDescription("@" + user.getAsTag() + " has claimed it! They found a " + item.getLable() + ".");
            channel.editMessageEmbedsById(msgid, message.build()).submit();
            if (Redis.getJedis().hexists(guildid, user.getId())) {
                JSONObject itemaccount = Redis.getUser(guildid, user.getId());
                Integer claim = itemaccount.getInt("total_claims") + 1;
                if (itemaccount.has(item.getLable())) {
                    Integer perItem = itemaccount.getInt(item.getLable()) + 1;
                    itemaccount.put(item.getLable(), perItem);
                } else {
                    itemaccount.put(item.getLable(), 1);
                }
                itemaccount.put("total_claims", claim);
                Redis.saveUser(guildid, user.getId(), itemaccount);
            } else {
                JSONObject itemaccount = new JSONObject();
                itemaccount.put("total_claims", 1);
                itemaccount.put(item.getLable(), 1);
                Redis.saveUser(guildid, user.getId(), itemaccount);
            }
            ItemDiscordBot.getItemManager().removeActiveItem(guildid, channel.getId());
        } else {
            channel.sendMessage("Sorry @" + user.getAsTag() + " this reward has already been claimed.").submit();
        }
    }
}
