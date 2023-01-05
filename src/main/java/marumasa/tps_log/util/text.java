package marumasa.tps_log.util;

import marumasa.tps_log.Config;

import java.text.DecimalFormat;

public class text {
    public static String TextTPS(double TPS, final Config config) {

        String text = config.LoadText;

        if (TPS > config.Value_VeryLow) {
            text += config.Text_VeryLow;
            TPS = config.MaxTPS;
        } else if (TPS > config.Value_Low) {
            text += config.Text_Low;
        } else if (TPS > config.Value_Medium) {
            text += config.Text_Medium;
        } else if (TPS > config.Value_High) {
            text += config.Text_High;
        } else {
            text += config.Text_VeryHigh;
        }
        final String StringTPS = new DecimalFormat("##0.00").format(TPS);
        final String MaxTPS = new DecimalFormat("##0.00").format(config.MaxTPS);

        return StringTPS + " / " + MaxTPS + " " + text;
    }
}
