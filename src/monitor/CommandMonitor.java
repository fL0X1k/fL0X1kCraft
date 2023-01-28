package monitor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import memory.PlayerCollector;
import net.md_5.bungee.api.ChatColor;

public class CommandMonitor implements Listener {
	
	public CommandMonitor() {
	}

	@EventHandler
	public void onPlayerAsyncChat(AsyncPlayerChatEvent chatEvent) {
		
		Player player = (Player) chatEvent.getPlayer();
		String message = chatEvent.getMessage().trim();
		
		if (isCommandFormat(message)) {
			
			chatEvent.setCancelled(true);
			
			if (message.contains("!killme")) {
				player.setHealth(0);
			} else if (message.contains("!help")) {
				player.sendMessage("");
				player.sendMessage("> Commands: ");
				player.sendMessage(" !killme - Kill self (same as /kill but you no need permissions)");
				player.sendMessage(" !info - shows actual info about server");
				player.sendMessage("");
			} else if (message.contains("!info")) {
				player.sendMessage("");
				player.sendMessage("> Server info:");
				player.sendMessage(" Online players: " + PlayerCollector.getOnlinePlayers());
				player.sendMessage("");
			} else {
				player.sendMessage(ChatColor.YELLOW + "Undefined command. Try use !help");
			}
		}
	}
	
	public boolean isCommandFormat(String args) {
		return args.startsWith("!") && args.split("!")[1].trim() != "";
	}
}
