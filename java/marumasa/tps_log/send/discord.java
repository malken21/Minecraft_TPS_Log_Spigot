package marumasa.tps_log.send;

import marumasa.tps_log.Config;
import marumasa.tps_log.request;
import marumasa.tps_log.util.time;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class discord extends Thread {

    //----------Thread----------//

    private final String url;
    private final String json;

    public discord(final Config config, final String textTPS) {
        final String timestamp = time.ISO8601(new Date());
        url = config.URL;
        json = String.format(
                "{\"embeds\":[{\"title\":\"%s\",\"color\":%d,\"timestamp\":\"%s\"}]}",
                textTPS,
                config.EmbedColor,
                timestamp
        );
    }

    public discord(final Config config, final String textTPS, final List<Map<String, String>> playerMap) {

        String field = "";

        if (playerMap.size() != 0) {

            StringBuilder name = new StringBuilder();
            StringBuilder world = new StringBuilder();
            StringBuilder location = new StringBuilder();
            StringBuilder uuid = new StringBuilder();

            for (final Map<String, String> player : playerMap) {

                if (name.length() != 0) name.append("\\n");
                name.append(player.get("name"));

                if (config.World) {
                    if (world.length() != 0) world.append("\\n");
                    world.append(player.get("world"));
                }
                if (config.Location) {
                    if (location.length() != 0) location.append("\\n");
                    location.append(player.get("location"));
                }
                if (config.UUID) {
                    if (uuid.length() != 0) uuid.append("\\n");
                    uuid.append(player.get("uuid"));
                }
            }

            StringBuilder data = new StringBuilder();

            data.append(String.format("{\"name\":\"%s\",\"value\":\"%s\",\"inline\":true}", config.playerNameText, name));
            if (config.World) {
                if (data.length() != 0) data.append(",");
                data.append(String.format("{\"name\":\"%s\",\"value\":\"%s\",\"inline\":true}", config.playerWorldText, world));
            }
            if (config.Location) {
                if (data.length() != 0) data.append(",");
                data.append(String.format("{\"name\":\"%s\",\"value\":\"%s\",\"inline\":true}", config.playerLocationText, location));
            }
            if (config.UUID) {
                if (data.length() != 0) data.append(",");
                data.append(String.format("{\"name\":\"%s\",\"value\":\"%s\",\"inline\":true}", config.playerUUIDText, uuid));
            }

            field = String.format("\"fields\":[%s],", data);
        }
        final String timestamp = time.ISO8601(new Date());
        url = config.URL;
        json = String.format(
                "{\"embeds\":[{\"title\":\"%s\",\"color\":%d,\"timestamp\":\"%s\",%s\"description\":\"%s\"}]}",
                textTPS,
                config.EmbedColor,
                timestamp,
                field,
                config.playerListText + " : " + playerMap.size()
        );
    }

    public void run() {
        request.post(url, json);
    }
}