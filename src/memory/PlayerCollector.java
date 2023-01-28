package memory;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerCollector {

	private static List<Player> playerList = new ArrayList<Player>();
	
	public PlayerCollector() {

		if (getOnlinePlayers() != 0) {
			playerList.clear();
		}
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			playerList.add(player);
		}
	}
	
	public static void registerPlayer(Player player) {
		if (!isRegistered(player))
			playerList.add(player);
	}

	public static void unRegisterPlayer(Player player) {
		if (isRegistered(player))
			playerList.remove(player);
	}
	
	public static boolean isRegistered(Player player) {
		return playerList.contains(player) ? true : false;
	}
	
	public static int getOnlinePlayers() {
		return (int) Bukkit.getOnlinePlayers().size();
	}
}
