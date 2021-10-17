package net.projectrefresh.Database;

import lombok.Getter;
import org.json.JSONObject;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;

import java.util.ArrayList;
import java.util.List;

public class Redis {

    @Getter
    private static ShardedJedis jedis;

    public Redis(String host, int port, String password) {
        System.out.println("[Redis] Starting the Jedis Client.");
        List<JedisShardInfo> shards = new ArrayList<>();
        JedisShardInfo si = new JedisShardInfo(host, port);
        si.setPassword(password);
        shards.add(si);
        jedis = new ShardedJedis(shards);
        System.out.println("[Redis] Jedis is connected!.");
    }

    public static JSONObject getUser(String guildid, String discordID) {
        return new JSONObject(jedis.hget("DiscordBot", discordID));
    }

    public static void saveUser(String guildid, String discordid, JSONObject object) {
        jedis.hset(guildid, discordid, object.toString());
    }

    public static int getPermissionLevel(String guildid, String discordID){
        JSONObject object = getUser(guildid, discordID);
        if (object.isNull("permission_level")){
            return 0;
        }
        else {
            return object.getInt("permission_level");
        }
    }

    public static void setPermissionLevel(String guildid, String discordID, Integer level){
        JSONObject object = getUser(guildid, discordID);
        object.put("permission_level", level);
        saveUser(guildid, discordID, object);
    }


}
