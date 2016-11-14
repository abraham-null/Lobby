package abraham;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import API.TokenAPI;
import BungeeTokens.BungeeTokens.BungeeTokens;
import Listeners.CommandListen;
import Listeners.PlayerListen;
import LobbyMenu.MainLobbyMenu;
import LobbyMenu.MainMenu;
import LobbyMenu.Servers;
import LobbyMenu.Tokens;



public class Lobby extends JavaPlugin{

	public BungeeTokens bungeeTokens = (BungeeTokens) getServer().getPluginManager().getPlugin("BungeeTokens");
	public TokenAPI tokenApi = new TokenAPI(bungeeTokens);
	public MySQLAPI mySQLAPI = (MySQLAPI) getServer().getPluginManager().getPlugin("MySQLAPI");
	public SQLManager sqlManager = new SQLManager(mySQLAPI);
	public MainLobbyMenu mainLobbyMenu;
	public List<MainMenu> menuArray = new ArrayList<MainMenu>();
	
	
	public HashMap<UUID, Integer> playerTokensHashMap = new HashMap<UUID, Integer>();

	public int playerCount;

	@Override
	public void onDisable() {
	}

	@Override
	public void onEnable() {

		this.getCommand("test").setExecutor(new CommandListen(this));
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerListen(this), this);
		mainLobbyMenu =  new MainLobbyMenu(this);
		
		menuArray.add(new Servers());
		menuArray.add(new Tokens());
		
	}


	
	

}
