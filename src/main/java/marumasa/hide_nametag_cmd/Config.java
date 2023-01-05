package marumasa.hide_nametag_cmd;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    public final String hideMessage;
    public final String showMessage;

    public Config(final minecraft plugin) {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();

        hideMessage = config.getString("hideMessage");
        showMessage = config.getString("showMessage");
    }
}
