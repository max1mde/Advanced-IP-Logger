package dev.maximde.datalogger.bungee;

import dev.maximde.datalogger.bungee.commands.GetData;
import dev.maximde.datalogger.bungee.commands.ListAltAccounts;
import dev.maximde.datalogger.bungee.events.JoinEvent;
import dev.maximde.datalogger.bungee.events.QuitEvent;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;


public class DataLogger extends Plugin {

	  private static CommandSender console;
	
	public void onEnable() {
		registerEvents();
		registerCommands();
	    this.console = getProxy().getConsole();
	    this.console.sendMessage("§c==>> §4§kAdvanced IP Logger§r§c <<==");
	    this.console.sendMessage("§c============================");
	    this.console.sendMessage("§c=========§3BungeeCord§c=========");
	    this.console.sendMessage("§c============================");
	    this.console.sendMessage("§c======Plugin by MaximDe=====");
	    this.console.sendMessage("§bhttps://discord.gg/ahxyCMT8bM");
	    this.console.sendMessage("§bhttps://www.spigotmc.org/members/maximde.1620695/");
	    this.console.sendMessage("§c============================");
	}
	
	public void registerEvents() {
		getProxy().getPluginManager().registerListener(this, (Listener)new JoinEvent());
		getProxy().getPluginManager().registerListener(this, (Listener)new QuitEvent());
	}
	
	public void registerCommands() {
		getProxy().getPluginManager().registerCommand( this, new GetData("getdata"));
		getProxy().getPluginManager().registerCommand( this, new ListAltAccounts("getalts") );
	}
	
	public static CommandSender getConsole() {
		return console;
	}
	
	/**
	 * MaximDe 2022.
	 * 
	 * LINKS:
	 * https://github.com/JavaDevMC
	 * https://www.spigotmc.org/members/maximde.1620695/
	 */
}
