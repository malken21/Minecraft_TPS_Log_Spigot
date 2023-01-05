package marumasa.hide_nametag_cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.Set;

public class NameTagToggle implements CommandExecutor {
    private Team team;
    private final Config con;

    public NameTagToggle(Scoreboard scoreboard, Config config) {
        con = config;
        team = scoreboard.getTeam("marumasa.HideNameTag");

        if (team == null)
            team = scoreboard.registerNewTeam("marumasa.HideNameTag");

        team.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER);
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        final Player senderPlayer = (Player) sender;
        final String senderPlayerName = senderPlayer.getName();
        final Set<String> Entries = team.getEntries();

        for (String Name : Entries)
            if (Name.equals(senderPlayerName)) {
                team.removeEntry(senderPlayerName);
                senderPlayer.sendMessage(con.showMessage);
                return true;
            }

        senderPlayer.sendMessage(con.hideMessage);
        team.addEntry(senderPlayerName);
        return true;
    }
}
