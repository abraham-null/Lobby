package abraham.ServerMenu;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import abraham.Lobby;

public class Survival extends ServerMenu {

	public Survival() {
		this.mat = Material.DIAMOND_SWORD;
		this.position = 21;
		this.displayTitle = ChatColor.YELLOW.toString() + ChatColor.BOLD.toString() + "Survival";
		this.lore = new ArrayList<String>();
		updateCount();
	}

	public void updateCount() {
		this.lore.clear();
		this.lore.add(ChatColor.WHITE.toString() + "Online: " + ChatColor.GRAY.toString() + "("
				+ Lobby.plugin.survivalPlayerCount + "/200)");
		this.lore.add("");
		this.lore.add(ChatColor.WHITE.toString() + " Economy Survival Server");
		this.lore.add(ChatColor.WHITE.toString() + " Over 200 custom biomes and many");
		this.lore.add(ChatColor.WHITE.toString() + " custom monster designs.");
		this.lore.add("");
		this.lore.add(ChatColor.YELLOW.toString() + ChatColor.BOLD.toString() + "Click to join!");

	}
	
	public void action(Player p){
		Lobby.plugin.sendToServer(p, "survival");
	}

}
