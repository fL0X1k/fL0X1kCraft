package core;

import org.bukkit.plugin.java.JavaPlugin;

import display.ServerListUtility;
import monitor.ConnectionMonitor;

public class Start extends JavaPlugin {

	public static boolean keepRunning;
	
	@Override
	public void onEnable() {
		keepRunning = true;
		
		getServer().getPluginManager().registerEvents(new ConnectionMonitor(), this);
		getServer().getPluginManager().registerEvents(new ServerListUtility(), this);
	}
	
	public void onDisable() {
		keepRunning = false;
	}
}
