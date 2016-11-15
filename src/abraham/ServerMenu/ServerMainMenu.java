package abraham.ServerMenu;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import abraham.Lobby;
import abraham.LobbyMenu.MainMenu;

public class ServerMainMenu {
	
	private int size = 54;
	
	
	public void showServerMenu(Player p){
		Inventory inv;
		inv = Bukkit.createInventory(null, size, Lobby.plugin.serverstitle);
		
		ArrayList<String> loreArray = new ArrayList<String>();
		
		for (int i = 0; i < Lobby.plugin.serverArray.size(); i++) {
			ServerMenu menu = Lobby.plugin.serverArray.get(i);

			Material mat = menu.getMat();
			String title = menu.getDisplayTitle();
			int invPosition = menu.getPosition();
			menu.updateCount();
			loreArray = menu.getLore();

			inv.setItem(invPosition, createItem(mat, title, loreArray));
			//loreArray.clear();

		}
		p.openInventory(inv);
		
	}

	public void go(Player p, String title){
		for (int i = 0; i < Lobby.plugin.serverArray.size(); i++){
			if (Lobby.plugin.serverArray.get(i).getDisplayTitle().equals(title)){
				Lobby.plugin.serverArray.get(i).action(p);
			}
		}
	}

	public static ItemStack createItem(Material mat, String title, ArrayList<String> loreArray) {

		ItemStack item = new ItemStack(mat);
		ItemMeta itemMeta = item.getItemMeta();

		itemMeta.setDisplayName(title);

		ArrayList<String> lore = new ArrayList<String>();
		lore.addAll(loreArray);

		itemMeta.setLore(lore);

		itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(itemMeta);

		return item;

	}
	
}
