package Listeners;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import BungeeTokens.BungeeTokens.BungeeTokens;
import abraham.Lobby;

public class CommandListen implements CommandExecutor {
	
    private Lobby plugin;

    public CommandListen(Lobby plugin) {
        this.plugin = plugin;
    }

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			return false;
		}

		if (cmd.getName().equalsIgnoreCase("test")) {
			plugin.tokenApi.showMenu((Player) sender);
		}
		return false;
		}


}
