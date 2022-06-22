package marumasa.tps_log;

import marumasa.tps_log.TPS.TPS;
import org.bukkit.plugin.java.JavaPlugin;

public final class minecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        Config config = new Config(this);
        new TPS(this,config).runTaskTimer(this, 0L, config.tick);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}