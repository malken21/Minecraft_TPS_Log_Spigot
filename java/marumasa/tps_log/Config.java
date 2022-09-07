package marumasa.tps_log;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    public final int Value_VeryLow;
    public final int Value_Low;
    public final int Value_Medium;
    public final int Value_High;

    public final String Text_VeryLow;
    public final String Text_Low;
    public final String Text_Medium;
    public final String Text_High;
    public final String Text_VeryHigh;

    public final int MaxTPS;
    public final String URL;
    public final boolean Discord;
    public final boolean Log;
    public final String LoadText;
    public final int WarnTPS;
    public final long tick;
    public final boolean playerList;
    public final boolean World;
    public final boolean Location;
    public final boolean UUID;
    public final int EmbedColor;

    public final String playerListText;
    public final String playerNameText;
    public final String playerWorldText;
    public final String playerLocationText;
    public final String playerUUIDText;

    public Config(final minecraft plugin) {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();

        Value_VeryLow = config.getInt("status.Value.VeryLow");
        Value_Low = config.getInt("status.Value.Low");
        Value_Medium = config.getInt("status.Value.Medium");
        Value_High = config.getInt("status.Value.High");

        Text_VeryLow = config.getString("status.Text.VeryLow");
        Text_Low = config.getString("status.Text.Low");
        Text_Medium = config.getString("status.Text.Medium");
        Text_High = config.getString("status.Text.High");
        Text_VeryHigh = config.getString("status.Text.VeryHigh");

        MaxTPS = config.getInt("MaxTPS");
        URL = config.getString("WebhookURL");
        Discord = config.getBoolean("Discord");
        Log = config.getBoolean("ServerLog");
        LoadText = config.getString("status.LoadText");
        WarnTPS = config.getInt("WarnTPS");
        tick = config.getLong("tick");
        EmbedColor = config.getInt("EmbedColor");

        playerList = config.getBoolean("playerList");
        World = config.getBoolean("World");
        Location = config.getBoolean("Location");
        UUID = config.getBoolean("UUID");

        playerListText = config.getString("playerListText");
        playerNameText = config.getString("playerNameText");
        playerWorldText = config.getString("playerWorldText");
        playerLocationText = config.getString("playerLocationText");
        playerUUIDText = config.getString("playerUUIDText");
    }
}