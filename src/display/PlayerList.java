package display;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import core.Start;
import memory.PlayerCollector;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R1.*;

public class PlayerList implements Runnable {

	private final boolean autoRefresh;
	
	public PlayerList(boolean autoRefresh) {
		this.autoRefresh = autoRefresh;
	}

	public void run() {
		
		if (!autoRefresh)
			return;
		
		while (Start.keepRunning) {
			
			for (Player player : Bukkit.getOnlinePlayers()) {
				setupDisplay(player);
			}
			
			try {
				Thread.sleep(1000 * 4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void setupDisplay(Player player) {
		
		IChatBaseComponent headerComponent = ChatSerializer.a("{\"text\": \"\n     " + ChatColor.WHITE + ChatColor.BOLD + "Welcome to fL0X1k server     \n\"}");
		IChatBaseComponent footerComponent = ChatSerializer.a("{\"text\": \"\n     " + ChatColor.WHITE + "www.flox.tk | Online players: " + PlayerCollector.getOnlinePlayers() + " / " + Bukkit.getMaxPlayers() + "     \n        Server running at Homelab        \n\"}");
		
		PacketPlayOutPlayerListHeaderFooter tablistPacket = new PacketPlayOutPlayerListHeaderFooter();

		try {
			Field headerField = tablistPacket.getClass().getDeclaredField("a");
			Field footerField = tablistPacket.getClass().getDeclaredField("b");
			
			headerField.setAccessible(true);
			headerField.set(tablistPacket, headerComponent);
			headerField.setAccessible(!headerField.isAccessible());
			
			footerField.setAccessible(true);
			footerField.set(tablistPacket, footerComponent);
			footerField.setAccessible(!footerField.isAccessible());
		} catch (Exception e) {
			e.printStackTrace();
		}

		CraftPlayer craftPlayer = (CraftPlayer) player;
		craftPlayer.getHandle().playerConnection.sendPacket(tablistPacket);
	}
}
