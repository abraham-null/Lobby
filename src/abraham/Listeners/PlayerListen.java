package abraham.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import abraham.Lobby;
import abraham.LobbyMenu.MainLobbyMenu;

public class PlayerListen implements Listener {

	private Lobby plugin;

	public PlayerListen(Lobby plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		p.teleport(new Location(p.getWorld(), 514, 37, 651, (float) -97, (float) 3.5));
		plugin.mainLobbyMenu.setLobbyItems(p);
	}
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e) {
		e.setCancelled(true);
	}


	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();

		if (p.isOp() == false) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onInventoryItemMove(InventoryClickEvent e) {
		if (e.getWhoClicked().isOp() == false) {
			e.setCancelled(true);
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		e.setCancelled(true);
		
		if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_AIR)) {
			String title = p.getItemInHand().getItemMeta().getDisplayName();
			Lobby.plugin.mainLobbyMenu.go(p, title);
		}
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);
		
		if(e.getInventory().getName().equals(Lobby.plugin.serverstitle)){
			String title = e.getCurrentItem().getItemMeta().getDisplayName();
			Lobby.plugin.serverMainMenu.go(p, title);
		}
		
		
	}
}
