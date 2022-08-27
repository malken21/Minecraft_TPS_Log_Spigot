package marumasa.tps_log;

public class discord extends Thread {

    //----------Thread----------//

    private final String url;
    private final String json;

    public discord(String URL, String JSON) {
        url = URL;
        json = JSON;
    }

    public void run() {
        request.post(url, json);
    }
}
