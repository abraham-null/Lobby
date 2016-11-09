package abraham;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import abraham.PlayerListener;

public class Lobby extends JavaPlugin {

	public MySQLAPI mySQLAPI = (MySQLAPI) getServer().getPluginManager().getPlugin("MySQLAPI");
	public SQLManager sqlManager;
	public TokenSQLManager tokenSQLManager;
	public PlayerScoreboards playerScoreboards = new PlayerScoreboards(this);
	public TokenClass tokenClass = new TokenClass(this);
	public ServerData ServerData = new ServerData(this);

	public HashMap<UUID, Integer> playerTokensHashMap = new HashMap<UUID, Integer>();

	public int playerCount;

	@Override
	public void onDisable() {
	}

	@Override
	public void onEnable() {

		sqlManager = new SQLManager(mySQLAPI);
		tokenSQLManager = new TokenSQLManager(mySQLAPI);

		Bukkit.getServer().getPluginManager().registerEvents(new Plistener(this), this);
		

		ServerData.reg();
		runUpdates();

	}

	public void runUpdates() {

		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			public void run() {

				Bukkit.getWorld("SUBHUB").setTime(18000);
				Bukkit.getWorld("SUBHUB").setStorm(false);
				Bukkit.getWorld("SUBHUB").setThundering(false);

				for (Player p : Bukkit.getServer().getOnlinePlayers()) {
					playerScoreboards.updateScoreboards(p);
				}
			}

		}, 20L, 40L);

	}

}
