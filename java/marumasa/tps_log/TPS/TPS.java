package marumasa.tps_log.TPS;

import marumasa.tps_log.Config;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class TPS extends BukkitRunnable {
    private final Plugin minecraft;
    private final Config config;

    public TPS(Plugin plugin,Config data) {
        minecraft = plugin;
        config = data;
    }

    @Override
    public void run() {
        new count(config).runTaskTimer(minecraft, 0L, 300L);
    }
}