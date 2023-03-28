package marumasa.tps_log.main;

import marumasa.tps_log.Config;
import marumasa.tps_log.send.discord;
import marumasa.tps_log.send.log;
import marumasa.tps_log.util.map;
import marumasa.tps_log.util.text;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class count extends BukkitRunnable {
    private final Date date;
    private final Config config;

    public count(final Config data) {
        config = data;
        date = new Date();
    }

    @Override
    public void run() {
        final double start = date.getTime();
        final double end = new Date().getTime();

        double result = 300 * 1000 / (end - start);

        if (result <= config.WarnTPS) {//-----Start!!-----//

            final String TextTPS = text.TextTPS(result, config);
            if (config.playerList) {
                final List<Map<String, String>> playerMap = map.playerMap(//Display PlayerData List
                        Bukkit.getServer().getOnlinePlayers(),
                        config.World,
                        config.Location,
                        config.UUID
                );
                if (config.Discord) new discord(config, TextTPS, playerMap).start();
                if (config.Log) log.send(config, TextTPS, playerMap);
            } else {
                if (config.Discord) new discord(config, TextTPS).start();
                if (config.Log) log.send(TextTPS);
            }
        }
    }
}
