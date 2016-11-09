package abraham;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class ServerData implements PluginMessageListener{

	private Lobby plugin;

	public ServerData(Lobby plugin) {
		this.plugin = plugin;
	}
	
	public void reg(){
		plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");
		plugin.getServer().getMessenger().registerIncomingPluginChannel(plugin, "BungeeCord", this);
	}

	public void setAllPlayersCount() {

		List<Player> players = new ArrayList<Player>(Bukkit.getOnlinePlayers());

		if (players.size() > 0) {
			Player p = players.get(0);

			ByteArrayDataOutput out = ByteStreams.newDataOutput();
			out.writeUTF("PlayerCount");
			out.writeUTF("ALL");
			p.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());

		}
	}
	
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		if (!channel.equals("BungeeCord")) {
			return;
		}

		ByteArrayDataInput in = ByteStreams.newDataInput(message);
		String subchannel = in.readUTF();

		if (subchannel.equals("PlayerCount")) {

					plugin.playerCount = in.readInt();
					// Bukkit.broadcastMessage(kitpvpPlayerCount+"");
		
			}
		}

}
