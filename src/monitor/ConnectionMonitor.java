package monitor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import core.Start;
import display.PlayerList;
import memory.PlayerCollector;
import net.md_5.bungee.api.ChatColor;

public class ConnectionMonitor implements Listener {
	
	private final String[] messagesArray = { "+ THIS SERVER HAS NO RULES, SO YOU CAN DO, WHAT YOU WANT.", "+ DDOSING OR OTHER ATTACK WILL BE BLOCKED.", "+ SUB TO MY CHANNEL: https://youtube.com/@fL0X3n" };
	
	public ConnectionMonitor() {
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent joinEvent) {
		
		joinEvent.setJoinMessage(null);

		Player player = (Player) joinEvent.getPlayer();

		for (int j = 0; j < 15; j++) {
			player.sendMessage("");
		}

		player.sendMessage(ChatColor.GRAY + " fL0XSystem v1.4 BETA active - www.flox.tk");
		player.sendMessage("");
		
		for (int j = 0; j < messagesArray.length; j++) {
			player.sendMessage(" " + messagesArray[j]);
		}
		
		player.sendMessage("");

		PlayerCollector.registerPlayer(player);
		PlayerList.setupDisplay(player);
		
		if (!Start.keepRunning) {
			Start.keepRunning = true;
			new Thread(new PlayerList(true)).start();
		}
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent quitEvent) {
		
		quitEvent.setQuitMessage(null);
		
		Player player = (Player) quitEvent.getPlayer();
		
		PlayerCollector.unRegisterPlayer(player);
	
		Start.keepRunning = false;
	}
}
