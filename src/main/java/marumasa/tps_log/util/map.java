package marumasa.tps_log.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.*;

public class map {
    public static List<Map<String, String>> playerMap(Collection<? extends Player> Players, final boolean World, final boolean Location, final boolean UUID) {
        final List<Map<String, String>> PlayerData = new ArrayList<>();

        for (Player player : Players) {
            final Location loc = player.getLocation();
            final Map<String, String> data = new HashMap<>();

            //-----PlayerData-----//
            data.put("name", player.getDisplayName().replaceAll("§([0-9a-f]|r|l|o|n|m|k)", ""));
            if (World)
                data.put("world", player.getWorld().getName());
            if (Location)
                data.put("location", String.format("%s %s %s", loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()));
            if (UUID)
                data.put("uuid", player.getUniqueId().toString().replaceAll("-", ""));
            //--------------------//

            PlayerData.add(data);
        }
        return PlayerData;
    }
}
