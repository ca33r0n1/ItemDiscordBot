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
    private final String _host;
    private final int _port;
    private final String _password;


    public Redis(String host, int port, String password) {
        this._host = host;
        this._port = port;
        this._password = password;

        List<JedisShardInfo> shards = new ArrayList<>();
        JedisShardInfo si = new JedisShardInfo(this._host, this._port);
        si.setPassword(this._password);
        shards.add(si);
        jedis = new ShardedJedis(shards);
    }

    public static JSONObject getUser(String discordID) {
        return new JSONObject(jedis.hget("DiscordBot", discordID));
    }

    public static void saveUser(String discordid, JSONObject object) {
        jedis.hset("DiscordBot", discordid, object.toString());
    }

    public static int getPermissionLevel(String discordID){
        JSONObject object = getUser(discordID);
        if (object.isNull("permission_level")){
            return 0;
        }
        else {
            return object.getInt("permission_level");
        }
    }

    public static void setPermissionLevel(String discordID, Integer level){
        JSONObject object = getUser(discordID);
        object.put("permission_level", level);
        saveUser(discordID, object);
    }


}
