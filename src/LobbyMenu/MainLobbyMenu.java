package LobbyMenu;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import abraham.Lobby;

public class MainLobbyMenu implements Listener{

	private Lobby plugin;
	
	public MainLobbyMenu(Lobby plugin) {
	}


	public void setLobbyItems(Player p){
		ArrayList<String> loreArray = new ArrayList<String>();
		Inventory inv = p.getInventory();
		
		for (int i = 0; i < plugin.menuArray.size(); i++) {
			MainMenu menu = plugin.menuArray.get(i);
			
			Material mat = menu.getMat();
			String title = menu.getDisplayTitle();
			int invPosition = menu.getPosition();
			loreArray = menu.getLore();
			
			p.getInventory().setItem(invPosition,createItem(mat, title, loreArray));
			loreArray.clear();
			
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
