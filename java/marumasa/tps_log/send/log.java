package marumasa.tps_log.send;

import marumasa.tps_log.Config;
import org.bukkit.Bukkit;

import java.util.List;
import java.util.Map;

public class log {
    public static void send(final Config config, final String textTPS, final List<Map<String, String>> playerMap) {
        Bukkit.getLogger().warning("----------Warn TPS----------");
        Bukkit.getLogger().warning(textTPS);
        Bukkit.getLogger().warning(config.playerListText + " : " + playerMap.size());
        for (Map<String, String> player : playerMap) {
            StringBuilder DisplayData = new StringBuilder(player.get("name"));

            if (config.World) DisplayData.append("  ").append(player.get("world"));
            if (config.Location) DisplayData.append("  ").append(player.get("location"));
            if (config.UUID) DisplayData.append("  ").append(player.get("uuid"));

            Bukkit.getLogger().warning(DisplayData.toString());
        }
        Bukkit.getLogger().warning("----------------------------");
    }

    public static void send(final String textTPS) {
        Bukkit.getLogger().warning("----------Warn TPS----------");
        Bukkit.getLogger().warning(textTPS);
        Bukkit.getLogger().warning("----------------------------");
    }
}
