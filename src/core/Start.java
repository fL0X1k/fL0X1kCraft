package core;

import org.bukkit.plugin.java.JavaPlugin;

import display.*;
import monitor.*;

public class Start extends JavaPlugin {

	public static boolean keepRunning;
	
	@Override
	public void onEnable() {
		keepRunning = true;
		
		getServer().getPluginManager().registerEvents(new ConnectionMonitor(), this);
		getServer().getPluginManager().registerEvents(new ServerListUtility(), this);
		getServer().getPluginManager().registerEvents(new CommandMonitor(), this);
		getServer().getPluginManager().registerEvents(new ChatMonitor(), this);
		
		new Thread(new PlayerList(true)).start();
	}
	
	@Override
	public void onDisable() {
		keepRunning = false;
	}
}
