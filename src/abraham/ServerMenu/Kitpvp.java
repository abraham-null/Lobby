package abraham.ServerMenu;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;


import abraham.Lobby;

public class Kitpvp extends ServerMenu {

	public Kitpvp() {
		this.mat = Material.IRON_HELMET;
		this.position = 23;
		this.displayTitle = ChatColor.YELLOW.toString() + ChatColor.BOLD.toString() + "Kit PVP";
		this.lore = new ArrayList<String>();
		updateCount();
	}

	public void updateCount() {
		this.lore.clear();
		this.lore.add(ChatColor.WHITE.toString() + "Online: " + ChatColor.GRAY.toString() + "(" + Lobby.plugin.kitpvpPlayerCount
				+ "/180)");
		this.lore.add("");
		this.lore.add(ChatColor.WHITE.toString() + " Grab a Kit and Fight!");
		this.lore.add(ChatColor.WHITE.toString() + " Earn money, level up,");
		this.lore.add(ChatColor.WHITE.toString() + " unlock supply crates and more!");
		this.lore.add("");
		this.lore.add(ChatColor.YELLOW.toString() + ChatColor.BOLD.toString() + "Click to join!");

	}
	
	public void action(Player p){
		Lobby.plugin.sendToServer(p, "kitpvp");
	}

}
