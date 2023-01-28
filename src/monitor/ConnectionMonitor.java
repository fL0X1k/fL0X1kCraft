package monitor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

public class ConnectionMonitor implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent joinEvent) {
		
		Player player = (Player) joinEvent.getPlayer();
		
		joinEvent.setJoinMessage(null);
		
		for (int j = 0; j < 15; j++) {
			player.sendMessage("");
		}
		
		player.sendMessage(ChatColor.GRAY + " + THIS SERVER HAS NO RULES, SO YOU CAN DO, WHAT YOU WANT.");
		player.sendMessage(ChatColor.GRAY + " + DDOSING OR OTHER ATTACK WILL BE BLOCKED.");
		player.sendMessage(ChatColor.GRAY + " + SUB TO MY CHANNEL: https://youtube.com/@fL0X3n");
		player.sendMessage("");
	}
}
