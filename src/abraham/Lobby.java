package abraham;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import API.TokenAPI;
import BungeeTokens.BungeeTokens.BungeeTokens;
import BungeeTokens.BungeeTokens.ConnectionPoolManager;
import abraham.Listeners.CommandListen;
import abraham.Listeners.PlayerListen;
import abraham.LobbyMenu.HidePlayers;
import abraham.LobbyMenu.MainLobbyMenu;
import abraham.LobbyMenu.MainMenu;
import abraham.LobbyMenu.Servers;
import abraham.LobbyMenu.Tokens;
import abraham.ServerMenu.Kitpvp;
import abraham.ServerMenu.ServerMainMenu;
import abraham.ServerMenu.ServerMenu;
import abraham.ServerMenu.Survival;
import abraham.ServerMenu.skyblock;
import abraham.scoreboards.scoreboardClass;




public class Lobby extends JavaPlugin implements PluginMessageListener{

	public BungeeTokens bungeeTokens = (BungeeTokens) getServer().getPluginManager().getPlugin("BungeeTokens");
	public TokenAPI tokenApi = new TokenAPI(bungeeTokens);
	//public MySQLAPI mySQLAPI = (MySQLAPI) getServer().getPluginManager().getPlugin("MySQLAPI");
	//public SQLManager sqlManager = new SQLManager(mySQLAPI);
	public MainLobbyMenu mainLobbyMenu;
	public ServerMainMenu serverMainMenu;
	public scoreboardClass scoreboardClass;
	public ArrayList<MainMenu> menuArray = new ArrayList<MainMenu>();
	public ArrayList<ServerMenu> serverArray = new ArrayList<ServerMenu>();
	public static Lobby plugin;
	public int survivalPlayerCount = 0;
	public int skyblockPlayerCount = 0;
	public int kitpvpPlayerCount = 0;
	public int allPlayerCount = 0;
	public String serverNAme = "";
	public String serverstitle = "SERVERS";


	@Override
	public void onDisable() {
		plugin = null;
	}

	@Override
	public void onEnable() {
		plugin = this;
		
		//pool = new ConnectionPoolManager(this);
		this.getCommand("test").setExecutor(new CommandListen(this));
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerListen(this), this);
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
		mainLobbyMenu =  new MainLobbyMenu(this);
		serverMainMenu =  new ServerMainMenu();
		scoreboardClass = new scoreboardClass();
		
		updater();
		
		
		menuArray.add(new Servers());
		menuArray.add(new Tokens());
		menuArray.add(new HidePlayers());

		serverArray.add(new Survival());
		serverArray.add(new skyblock());
		serverArray.add(new Kitpvp());
		
	}

	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		if (!channel.equals("BungeeCord")) {
			return;
		}

		ByteArrayDataInput in = ByteStreams.newDataInput(message);
		String subchannel = in.readUTF();

		if (subchannel.equals("PlayerCount")) {

			serverNAme = in.readUTF();
			if (serverNAme != null) {
				// Bukkit.broadcastMessage(serverNAme);

				if (serverNAme.equalsIgnoreCase("survival")) {
					survivalPlayerCount = in.readInt();
				}
				
				if (serverNAme.equalsIgnoreCase("skyBlock")) {
					skyblockPlayerCount = in.readInt();
				}

				if (serverNAme.equalsIgnoreCase("Kit")) {
					kitpvpPlayerCount = in.readInt();
				}

				if (serverNAme.equalsIgnoreCase("ALL")) {
					allPlayerCount = in.readInt();
				}
			
			}
		}

	}
	
	@SuppressWarnings("deprecation")
	public void updater() {

		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			public void run() {
				
				Bukkit.getWorld("SUBHUB").setTime(18000);
				Bukkit.getWorld("SUBHUB").setStorm(false);
				Bukkit.getWorld("SUBHUB").setThundering(false);

				List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());

				if (players.size() > 0) {
		
					Player p = players.get(0);
					ByteArrayDataOutput out = ByteStreams.newDataOutput();
					out.writeUTF("PlayerCount");
					out.writeUTF("survival");
					p.sendPluginMessage(Lobby.plugin, "BungeeCord", out.toByteArray());
					
					ByteArrayDataOutput out2 = ByteStreams.newDataOutput();
					out2.writeUTF("PlayerCount");
					out2.writeUTF("kit");
					p.sendPluginMessage(Lobby.plugin, "BungeeCord", out2.toByteArray());
					
					ByteArrayDataOutput out3 = ByteStreams.newDataOutput();
					out3.writeUTF("PlayerCount");
					out3.writeUTF("skyblock");
					p.sendPluginMessage(Lobby.plugin, "BungeeCord", out3.toByteArray());
					
					ByteArrayDataOutput out4 = ByteStreams.newDataOutput();
					out4.writeUTF("PlayerCount");
					out4.writeUTF("ALL");
					p.sendPluginMessage(Lobby.plugin, "BungeeCord", out4.toByteArray());
					
					for(Player player : Bukkit.getServer().getOnlinePlayers()) {
						scoreboardClass.setScoreboard(player, allPlayerCount);
						}

				}
			}

		}, 20L, 40L);

	}
	
	public void sendToServer(Player p, String server) {

		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("Connect");
		out.writeUTF(server);
		p.sendPluginMessage(Lobby.plugin, "BungeeCord", out.toByteArray());

	}

}
