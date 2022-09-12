package marumasa.tps_log.send;

import marumasa.tps_log.Config;
import org.bukkit.Bukkit;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class log {
    private static final Logger Logger = Bukkit.getLogger();

    public static void send(final Config config, final String textTPS, final List<Map<String, String>> playerMap) {
        Logger.warning("----------Warn TPS----------");
        Logger.warning(textTPS);
        Logger.warning(config.playerListText + " : " + playerMap.size());
        for (Map<String, String> player : playerMap) {
            StringBuilder DisplayData = new StringBuilder(player.get("name"));

            if (config.World) DisplayData.append("  ").append(player.get("world"));
            if (config.Location) DisplayData.append("  ").append(player.get("location"));
            if (config.UUID) DisplayData.append("  ").append(player.get("uuid"));

            Logger.warning(DisplayData.toString());
        }
        Logger.warning("----------------------------");
    }

    public static void send(final String textTPS) {
        Logger.warning("----------Warn TPS----------");
        Logger.warning(textTPS);
        Logger.warning("----------------------------");
    }
}