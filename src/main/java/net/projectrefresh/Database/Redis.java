package net.projectrefresh.Database;

import lombok.Getter;
import net.projectrefresh.ItemDiscordBot;
import org.json.JSONObject;
import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

public class Redis {

    @Getter
    private static ShardedJedis jedis;

    public Redis(){
        List<JedisShardInfo> shards = new ArrayList<>();
        JedisShardInfo si = new JedisShardInfo(ItemDiscordBot.getProperties().getProperty("redis-host"), Integer.parseInt(ItemDiscordBot.getProperties().getProperty("redis-port")));
        si.setPassword(ItemDiscordBot.getProperties().getProperty("redis-password"));
        shards.add(si);
        jedis = new ShardedJedis(shards);
    }

    public static JSONObject getInv(String discordID){
        return new JSONObject(jedis.hget("DiscordBot", discordID));
    }

    public static void saveInv(String discordid, JSONObject object){
        jedis.hset("DiscordBot", discordid, object.toString());
    }


}
