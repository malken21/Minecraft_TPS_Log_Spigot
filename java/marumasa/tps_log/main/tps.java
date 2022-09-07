package marumasa.tps_log.main;

import marumasa.tps_log.Config;
import marumasa.tps_log.minecraft;
import org.bukkit.scheduler.BukkitRunnable;

public class tps extends BukkitRunnable {
    private final minecraft mc;
    private final Config config;

    public tps(final minecraft minecraft, final Config data) {
        mc = minecraft;
        config = data;
    }

    @Override
    public void run() {
        new count(config).runTaskTimer(mc, 0L, 300L);
    }
}