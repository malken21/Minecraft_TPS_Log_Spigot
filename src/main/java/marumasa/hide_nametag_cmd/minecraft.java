package marumasa.hide_nametag_cmd;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

public final class minecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Config config = new Config(this);

        getCommand("nttoggle").setExecutor(new NameTagToggle(scoreboard,config));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
