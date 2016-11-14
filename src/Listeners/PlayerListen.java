package Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import LobbyMenu.MainLobbyMenu;
import abraham.Lobby;

public class PlayerListen implements Listener {

	private Lobby plugin;

	public PlayerListen(Lobby plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		plugin.mainLobbyMenu.setLobbyItems(p);
	}

	
}
