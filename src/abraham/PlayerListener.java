package abraham;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
	

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.teleport(new Location(p.getWorld(), 514, 37, 651, (float) -97, (float) 3.5));
		
		//p.setScoreboard(new PlayerScoreboards(p));

	}

}
