package abraham;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;


public class Plistener implements Listener {

    private Lobby plugin;

    public Plistener(Lobby plugin) {
        this.plugin = plugin;
    }
    
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		int tokens = 0;
		tokens = plugin.tokenSQLManager.getPlayerTokens(p.getUniqueId().toString());
		plugin.playerTokensHashMap.put(p.getPlayer().getUniqueId(), tokens );
		
		plugin.ServerData.setAllPlayersCount();
		p.setScoreboard(plugin.playerScoreboards.getPlayerScoreboard(p, tokens));
//
	}

	public void onquit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		plugin.tokenClass.savePlayerTokens(p);
		plugin.playerTokensHashMap.remove(p.getUniqueId());
		p.setScoreboard(null);
	}


}
