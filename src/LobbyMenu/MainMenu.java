package LobbyMenu;

import java.util.ArrayList;

import org.bukkit.Material;

public class MainMenu {
	
	public Material mat;
    public int position;
    public String displayTitle;
    public ArrayList<String> lore = new ArrayList<String>();;
	    
	    public Material getMat() {
		return mat;
	}
	public void setMat(Material mat) {
		this.mat = mat;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getDisplayTitle() {
		return displayTitle;
	}
	public void setDisplayTitle(String displayTitle) {
		this.displayTitle = displayTitle;
	}
	public ArrayList<String> getLore() {
		return lore;
	}
	public void setLore(ArrayList<String> lore) {
		this.lore = lore;
	}
		

}