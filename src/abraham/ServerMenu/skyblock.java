package abraham.ServerMenu;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;


import abraham.Lobby;

public class skyblock extends ServerMenu {

	public skyblock() {
		this.mat = Material.GRASS;
		this.position = 22;
		this.displayTitle = ChatColor.YELLOW.toString() + ChatColor.BOLD.toString() + "SkyBlock";
		this.lore = new ArrayList<String>();
		updateCount();
	}

	public void updateCount() {
		this.lore.clear();
		this.lore.add(ChatColor.WHITE.toString() + "Online: " + ChatColor.GRAY.toString() + "(" + Lobby.plugin.skyblockPlayerCount
				+ "/180)");
		this.lore.add("");
		this.lore.add(ChatColor.WHITE.toString() + " Peaceful & Fun Island Survival");
		this.lore.add(ChatColor.WHITE.toString() + " Complete challenges, unlock new");
		this.lore.add(ChatColor.WHITE.toString() + " ranks, team, cat & level up!");
		this.lore.add("");
		this.lore.add(ChatColor.YELLOW.toString() + ChatColor.BOLD.toString() + "Click to join!");

	}
	
	public void action(Player p){
		Lobby.plugin.sendToServer(p, "skyblock");
	}

}
