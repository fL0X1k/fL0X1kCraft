package display;

import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import net.md_5.bungee.api.ChatColor;

public class ServerListUtility implements Listener {

	private final String[] messagesArray = { ChatColor.GOLD + "No rules! No queues!", ChatColor.GOLD + "Connection up to 400 Mbit/s", ChatColor.GOLD + "Running at homelab :P", ChatColor.RED + "WOW", ChatColor.GOLD + "Minecraft has been taught at school.", ChatColor.GOLD + "The Rarest item in Minecraft is the Dragon Egg.", ChatColor.GOLD + "One day in Minecraft is 20 minutes in real-time.", ChatColor.GOLD + "Each block is considered 1 cubic metre.", ChatColor.GOLD + "Around 126 million people people play Minecraft every month.", ChatColor.GOLD + "Over 200 million copies of Minecraft have been sold worldwide.", ChatColor.GOLD + "The Enderman language is the English language backwards,\nand sometimes just at a lower pitch. Yep, it was English all along.", ChatColor.GOLD + "The crafting table has named workbench.", ChatColor.GOLD + "POV: Peoples who refreshing for new motds :D", ChatColor.GOLD + ".party()!", ChatColor.GOLD + "Started at 28. 01. 2023", ChatColor.GOLD + "Never gonna give you up!", ChatColor.GOLD + "Rickrolling peoples are currently not funny.", ChatColor.GOLD + "www.flox.tk", ChatColor.RED + "Ketchup!" };
	
	@EventHandler
	public void countDown(ServerListPingEvent pingEvent) {
		pingEvent.setMotd(getRandomMessage());
	}
	
	public String getRandomMessage() {
		return messagesArray[new Random().nextInt(messagesArray.length)];
	}
}
