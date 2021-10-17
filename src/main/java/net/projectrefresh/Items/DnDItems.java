package net.projectrefresh.Items;

import lombok.Getter;
import lombok.Setter;

public enum DnDItems {
    BLUE_DRAGON("Ancient Blue Dragon", "https://www.dndbeyond.com/avatars/thumbnails/0/131/1000/1000/636252756020185006.jpeg"),

    BRONZE_DRAGON("Ancient Bronze Dragon", "https://www.dndbeyond.com/avatars/thumbnails/0/135/1000/1000/636252756372367681.jpeg"),

    COPPER_DRAGON("Ancient Copper Dragon", "https://www.dndbeyond.com/avatars/thumbnails/0/137/1000/1000/636252756714896878.jpeg"),

    WHITE_DRAGON("Ancient White Dragon", "https://www.dndbeyond.com/avatars/thumbnails/0/153/1000/1000/636252758955886210.jpeg"),

    BLACK_DRAGON("Ancient Black Dragon", "https://www.dndbeyond.com/avatars/thumbnails/0/129/1000/1000/636252755854649337.jpeg"),

    GOLD_DRAGON("Ancient Gold Dragon", "https://www.dndbeyond.com/avatars/thumbnails/0/139/1000/1000/636252756930565101.jpeg"),

    BRASS_DRAGON("Ancient Brass Dragon", "https://www.dndbeyond.com/avatars/thumbnails/0/133/1000/1000/636252756157427258.jpeg"),

    GREEN_DRAGON("Ancient Green Dragon", "https://www.dndbeyond.com/avatars/thumbnails/0/141/1000/1000/636252757319464533.jpeg"),

    RED_DRAGON("Ancient Red Dragon", "https://www.dndbeyond.com/avatars/thumbnails/0/147/1000/1000/636252758629652181.jpeg"),

    SILVER_DRAGON("Ancient Silver Dragon", "https://www.dndbeyond.com/avatars/thumbnails/0/151/1000/1000/636252758799225927.jpeg"),

    FIEND_INCUBUS("Incubus", "https://www.dndbeyond.com/avatars/thumbnails/5388/845/1000/1000/636857603667977177.png"),

    FIEND_SUCCUBUS("Ancient Black Dragon", "https://www.dndbeyond.com/avatars/thumbnails/0/103/1000/1000/636252742573312994.jpeg"),

    PC_MALI_EARUNDER("Earunder, Elf Bladesinger", "https://cdn.discordapp.com/attachments/857630251446304772/899212481581441044/Earunder3.png"),

    PC_MALI_DRAYDEN("Drayden, The Aberrant Mind", "https://cdn.discordapp.com/attachments/860193513723789373/899213480316506112/unknown_4.png"),
            ;

    @Getter
    private final String lable;

    @Getter
    private final String url;

    @Getter
    @Setter
    private boolean claimed;

    DnDItems(String Name, String url) {
        this.lable = Name;
        this.url = url;
    }
}
