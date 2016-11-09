package abraham;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;


public class PlayerScoreboards {
	
    private Lobby plugin;

    public PlayerScoreboards(Lobby plugin) {
        this.plugin = plugin;
    }

public Scoreboard getPlayerScoreboard(Player p, int tokens){
	
	Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();

	Objective objective = board.registerNewObjective("Test", "Test2");
	objective.setDisplayName(ChatColor.GOLD.toString() + ChatColor.BOLD + "TheLastHero");
	objective.setDisplaySlot(DisplaySlot.SIDEBAR);

	Team team = board.registerNewTeam("team");
	team.setPrefix(ChatColor.RED + "[team]");

	Score score1 = objective.getScore("thelasthero.net");
	score1.setScore(1);
	Score score2 = objective.getScore(ChatColor.AQUA + "IP & WEBSITE");
	score2.setScore(2);
	Score score3 = objective.getScore(ChatColor.WHITE.toString() + "�2");
	score3.setScore(3);
	Score score0 = objective.getScore(ChatColor.WHITE.toString() + "" + plugin.playerCount);
	score0.setScore(4);
	Score score4 = objective.getScore(ChatColor.AQUA + "Players");
	score4.setScore(5);
	Score score8 = objective.getScore("�3");
	score8.setScore(6);
	Score score9 = objective.getScore(""+tokens);
	score9.setScore(7);
	Score score10 = objective.getScore(ChatColor.AQUA + "Tokens");
	score10.setScore(8);
	Score score11 = objective.getScore("�4");
	score11.setScore(9);
	Score score12 = objective.getScore("Player");
	score12.setScore(10);
	Score score13 = objective.getScore(ChatColor.AQUA + "Rank");
	score13.setScore(11);
	
	return board;
	
}

public void updateScoreboards(Player p){
	p.setScoreboard(getPlayerScoreboard(p, plugin.playerTokensHashMap.get(p.getUniqueId())));
}

}
