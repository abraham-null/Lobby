package abraham;

import org.bukkit.entity.Player;

public class TokenClass {

    private Lobby plugin;

    public TokenClass(Lobby plugin) {
        this.plugin = plugin;
    }
 
    public int getPlayerTokens(Player p){
		int tokens = plugin.tokenSQLManager.getPlayerTokens(p.getUniqueId().toString());
    	return tokens;
    }
    
    public void savePlayerTokens(Player p){
    	int tokens  = plugin.playerTokensHashMap.get(p.getUniqueId());
    	plugin.tokenSQLManager.setTokens(p.getUniqueId().toString(), tokens);
    }
}
