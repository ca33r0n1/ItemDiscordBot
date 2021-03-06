package net.projectrefresh.Items;

import lombok.Getter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.projectrefresh.ItemDiscordBot;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ItemManager {

    private final List<HalloweenItem> VALUES =
            Collections.unmodifiableList(Arrays.asList(HalloweenItem.values()));
    private final int SIZE = VALUES.size();
    private final Random RANDOM = new Random();

    @Getter
    private LocalTime lastSpawnTime;

    @Getter
    @Deprecated
    public Item latestItem;

    private final ConcurrentHashMap<String, Item> channelActiveItems;


    public ItemManager(){
        System.out.println("[Item Manager] Starting Item Manager.");
        channelActiveItems = new ConcurrentHashMap<>();
        lastSpawnTime = LocalTime.now();
    }

    public void removeActiveItem(String guildid, String channelid){
        channelActiveItems.remove(channelid);
    }

    public @Nullable Item getChannelItem(String channelID){
        if (channelActiveItems.containsKey(channelID)){
            return channelActiveItems.get(channelID);
        }
        else {
            System.out.println("[Item Manager] Unable to get reward for channel - " + ItemDiscordBot.jda.getGuildChannelById(channelID).getName());
            return null;
        }
    }

    public ConcurrentHashMap.KeySetView<String, Item> getKeys(){
        return channelActiveItems.keySet();
    }

    public void addChannelItem(String channel, Item item){
        channelActiveItems.put(channel, item);
        System.out.println(item.getItem().getLable() + " has spawned in channel " + ItemDiscordBot.jda.getGuildChannelById(channel).getName());
    }

    public MessageEmbed spawnItem(String channel) {
        HalloweenItem halloweenItem = getRandomItem();
        String trickOrTreat = getRandomTrickOrTreat();
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Happy Halloween!");
        embedBuilder.setDescription(String.format("Knock Knock. Anyone here. type h!%s to earn an item.", trickOrTreat));
        embedBuilder.setImage(halloweenItem.getUrl());
        embedBuilder.setColor(Color.orange);
        embedBuilder.setFooter("Ty Discord for images - Bot by @Ca33r0n1#0001");
        Item item = new Item(halloweenItem, embedBuilder);
        ItemDiscordBot.getItemManager().addChannelItem(channel,item);
        return embedBuilder.build();
    }
  
    private String getRandomTrickOrTreat() {
        Random r = new Random();
        return r.nextBoolean() ? "trick" : "treat";
    }
    private HalloweenItem getRandomItem() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
