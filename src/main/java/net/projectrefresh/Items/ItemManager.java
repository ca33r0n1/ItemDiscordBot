package net.projectrefresh.Items;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ItemManager {

    private static final List<HalloweenItem> VALUES =
            Collections.unmodifiableList(Arrays.asList(HalloweenItem.values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    public static Item latestItem;

    public static MessageEmbed spawnItem() {
        HalloweenItem item = getRandomItem();
        String trickOrTreat = getRandomTrickOrTreat();
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Happy Halloween!");
        embedBuilder.setDescription(String.format("Knock Knock. Anyone here. type h!%s to earn an item.", trickOrTreat));
        embedBuilder.setImage(item.getUrl());
        embedBuilder.setColor(Color.orange);
        embedBuilder.setFooter("Ty Discord for images - Bot by @Ca33r0n1#0001");
        latestItem = new Item(item, embedBuilder);
        return embedBuilder.build();
    }
  
    private static String getRandomTrickOrTreat() {
        Random r = new Random();
        return r.nextBoolean() ? "trick" : "treat";
    }
    private static HalloweenItem getRandomItem() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
