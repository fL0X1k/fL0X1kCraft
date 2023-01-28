package monitor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.ChatColor;

public class ChatMonitor implements Listener {
	
	public ChatMonitor() {
	}

	@EventHandler
	public void onPlayerAsyncChat(AsyncPlayerChatEvent chatEvent) {
		
		Player player = (Player) chatEvent.getPlayer();
		String message = chatEvent.getMessage().trim();
		
		chatEvent.setFormat(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + player.getName() + ChatColor.YELLOW + " >> " + ChatColor.DARK_GRAY + ChatColor.BOLD + message);
	}
}
