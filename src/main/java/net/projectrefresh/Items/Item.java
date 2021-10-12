package net.projectrefresh.Items;

import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.projectrefresh.Database.Redis;
import org.json.JSONObject;

public class Item {

    private final HalloweenItem item;
    private final EmbedBuilder message;

    @Setter
    @Getter
    private String msgid;


    public Item(HalloweenItem item, EmbedBuilder message) {
        this.item = item;
        this.message = message;
    }

    public void claim(User user, MessageChannel channel) {
        if (!item.isClaimed()) {
            item.setClaimed(true);
            message.setDescription("@" + user.getAsTag() + " answered the call first and was given a " + item.getLable() + ".");
            channel.editMessageEmbedsById(msgid, message.build()).submit();
            if (Redis.getJedis().hexists("DiscordBot", user.getId())) {
                JSONObject itemaccount = Redis.getUser(user.getId());
                Integer claim = itemaccount.getInt("total_claims") + 1;
                if (itemaccount.has(item.getLable())) {
                    Integer perItem = itemaccount.getInt(item.getLable()) + 1;
                    itemaccount.put(item.getLable(), perItem);
                } else {
                    itemaccount.put(item.getLable(), 1);
                }
                itemaccount.put("total_claims", claim);
                Redis.saveUser(user.getId(), itemaccount);
            } else {
                JSONObject itemaccount = new JSONObject();
                itemaccount.put("total_claims", 1);
                itemaccount.put(item.getLable(), 1);
                Redis.saveUser(user.getId(), itemaccount);
            }
        } else {
            channel.sendMessage("Sorry @" + user.getAsTag() + " this reward has already been claimed.").submit();
        }
    }
}
