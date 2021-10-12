package net.projectrefresh.Items;

import lombok.Getter;
import lombok.Setter;

public enum HalloweenItem {
    ASSORTED_BUGS("Assorted Bugs", "https://cdn.discordapp.com/halloween-bot/Bat.png"),
    BARN_OWL_FEATHERS("Barn Owl Feathers", "https://cdn.discordapp.com/halloween-bot/Mothman.png"),
    BASIC_BRAIN("Basic Brain", "https://cdn.discordapp.com/halloween-bot/Zombie.png"),
    BENT_FEATHER("Bent Feather", "https://cdn.discordapp.com/halloween-bot/Knight.png"),
    BOWL_OF_ORCSLOP("Bowl of Orcslop", "https://cdn.discordapp.com/halloween-bot/Orc.png"),
    BOX_OF_BANDAGES("Box of Bandages", "https://cdn.discordapp.com/halloween-bot/Mummy.png"),
    BRIMSTONE("Brimstone","https://cdn.discordapp.com/halloween-bot/Demon.png"),
    BROKEN_TWIGS("Broken Twigs", "https://cdn.discordapp.com/halloween-bot/Crow.png"),
    CAPE_COUPON("Cape Coupon", "https://cdn.discordapp.com/halloween-bot/Vampire.png"),
    CHILLY_CHESS_PIECE("Chilly Chess Piece", "https://cdn.discordapp.com/halloween-bot/Reaper.png"),
    COBWEBS("Cobwebs", "https://cdn.discordapp.com/halloween-bot/Spider.png"),
    CONFUSING_CAPTCHAS("Confusing Captchas", "https://cdn.discordapp.com/halloween-bot/Robot.png"),
    COOL_GEODE("Cool Geode", "https://cdn.discordapp.com/halloween-bot/Bat.png"),
    COUGH_DROP("Cough Drop", "https://cdn.discordapp.com/halloween-bot/Plague-Doctor.png"),
    CRUSTY_BARNACLE("Crusty Barnacle", "https://cdn.discordapp.com/halloween-bot/Pirate.png"),
    DROP_OF_ECTOPLASM("Drop of Ectoplasm", "https://cdn.discordapp.com/halloween-bot/Ghost.png"),
    ENCHANTED_BLADE("Enchanted Blade","https://cdn.discordapp.com/halloween-bot/Knight.png"),
    EYE_OF_NEWT("Eye of Newt", "https://cdn.discordapp.com/halloween-bot/Witch.png"),
    FEARSOME_EYEPATCH("Fearsome Eyepatch", "https://cdn.discordapp.com/halloween-bot/Pirate.png"),
    FEATHER_BOA("Feather Boa", "https://cdn.discordapp.com/halloween-bot/Snake.png"),
    FOSSIL_FOOTPRINT("Fossil Footprint","https://cdn.discordapp.com/halloween-bot/Wumpus-Dino.png"),
    FRAGRANT_HERBS("Fragrant Herbs","https://cdn.discordapp.com/halloween-bot/Plague-Doctor.png" ),
    GLITCHING_GIZMO("Glitching Gizmo", "https://cdn.discordapp.com/halloween-bot/Gremlin.png"),
    GLOOMY_MASK("Gloomy Mask", "https://cdn.discordapp.com/halloween-bot/Plague-Doctor.png"),
    GOLDEN_CORN("Golden Corn", "https://cdn.discordapp.com/halloween-bot/Scarecrow.png"),
    GOURMET_JAM("Gourmet Jam", "https://cdn.discordapp.com/halloween-bot/Slime.png"),
    INFERNO_HOT_SAUCE("Inferno Hot Sauce", "https://cdn.discordapp.com/halloween-bot/Demon.png"),
    LUCKY_ROCK("Lucky Rock", "https://cdn.discordapp.com/halloween-bot/Goblin.png"),
    PEABRAIN("Peabrain","https://cdn.discordapp.com/halloween-bot/Zombie.png"),
    PRANK_FLOWER("Prank Flower", "https://cdn.discordapp.com/halloween-bot/Clown.png"),
    RAGGED_HAT("Ragged Hat", "https://cdn.discordapp.com/halloween-bot/Scarecrow.png"),
    RATTLIN_CHAINS("Rattlin' Chains", "https://cdn.discordapp.com/halloween-bot/Ghost.png"),
    ROASTED_SEED("Roasted Seed","https://cdn.discordapp.com/halloween-bot/Nice-Pumpkins.png"),
    SHEDDED_FUR("Shedded Fur","https://cdn.discordapp.com/halloween-bot/Werewolf.png"),
    SHINY_HELMET("Shiny Helmet", "https://cdn.discordapp.com/halloween-bot/Knight.png"),
    SHRINK_RAY("Shrink Ray", "https://cdn.discordapp.com/halloween-bot/Scientist.png"),
    SILVER_PANTS(" Silver Pants", "https://cdn.discordapp.com/halloween-bot/Alien.png"),
    SMUSHED_PUMPKIN("Smushed Pumpkin", "https://cdn.discordapp.com/halloween-bot/Centaur.png"),
    SPARE_BUTTON("Spare Button", "https://cdn.discordapp.com/halloween-bot/Teddy-Bear.png"),
    SWAMP_GAS("Swamp Gas", "https://cdn.discordapp.com/halloween-bot/Frog.png"),
    SWEET_BATTLEAXE("Sweet Battleaxe","https://cdn.discordapp.com/halloween-bot/Orc.png"),
    TINY_BOOTS("Tiny Boots", "https://cdn.discordapp.com/halloween-bot/Fairy.png"),
    USED_TOOTHPICK("Used Toothpick", "https://cdn.discordapp.com/halloween-bot/Vampire.png"),
    WET_KELP("Wet Kelp", "https://cdn.discordapp.com/halloween-bot/Man-shark.png"),
    WICKED_DAGGER("Wicked Dagger","https://cdn.discordapp.com/halloween-bot/Reaper.png"),
    WOLF_CLAW("Wolf Claw", "https://cdn.discordapp.com/halloween-bot/Werewolf.png"),
    WUMPLING_SOUP("Wumpling Soup", "https://cdn.discordapp.com/halloween-bot/Wumpus-Wumpus.png"),
    ;

    @Getter
    private final String lable;

    @Getter
    private final String url;

    @Getter @Setter
    private boolean claimed;

    HalloweenItem(String Name, String url) {
        this.lable = Name;
        this.url = url;
    }
}
