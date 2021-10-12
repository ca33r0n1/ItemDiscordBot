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

    public static JSONObject getInv(String discordID) {
        return new JSONObject(jedis.hget("DiscordBot", discordID));
    }

    public static void saveInv(String discordid, JSONObject object) {
        jedis.hset("DiscordBot", discordid, object.toString());
    }


}
