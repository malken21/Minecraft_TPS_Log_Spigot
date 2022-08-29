package marumasa.tps_log;

import marumasa.tps_log.main.tps;
import org.bukkit.plugin.java.JavaPlugin;

public final class minecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        Config config = new Config(this);
        new tps(this, config).runTaskTimer(this, config.tick, config.tick);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
