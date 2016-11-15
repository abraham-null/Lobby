package abraham.LobbyMenu;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import abraham.Lobby;

public class Tokens extends MainMenu{

	
	public Tokens(){
		this.mat = Material.GOLD_NUGGET;
		this.position = 4;
		this.displayTitle = "Tokens";
		this.lore.add("");
		this.lore.add("ccc");
		this.lore.add("ddd");
		this.lore.add("");
	}
	
	public void action(Player p){
		Lobby.plugin.tokenApi.showMenu(p);
	}

}
