package abraham.LobbyMenu;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import abraham.Lobby;

public class Servers extends MainMenu{

	
	public Servers(){
		this.mat = Material.ENDER_PEARL;
		this.position = 0;
		this.displayTitle = ChatColor.AQUA.toString() + "Navigator " + ChatColor.GRAY.toString() + "(Right Click)";
		this.lore = new ArrayList<String>();
		this.lore.add(ChatColor.WHITE.toString() + "Right click to open server selector!");
		this.lore.add("");
	}
	
	public void action(Player p){
		Lobby.plugin.serverMainMenu.showServerMenu(p);
	}
	


}
