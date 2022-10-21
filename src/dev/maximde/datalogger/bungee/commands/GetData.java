package dev.maximde.datalogger.bungee.commands;



import dev.maximde.datalogger.bungee.DataLogger;
import dev.maximde.datalogger.bungee.utils.BungeecordOfflinePlayer;
import dev.maximde.datalogger.bungee.utils.DataConfig;
import dev.maximde.datalogger.bungee.utils.IPManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;


public class GetData extends Command {
	

	public GetData(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer)sender;
			if(p.hasPermission("advancedlogger.getdata")) {
			if(args.length == 1) {
				ProxiedPlayer t = ProxyServer.getInstance().getPlayer(args[0]);
				BungeecordOfflinePlayer ot = new BungeecordOfflinePlayer(args[0]);
				if(!DataConfig.isRegistered(ot.getUniqueId().toString())) {
					p.sendMessage("§cPlayer not found!");
					return;
				}
				p.sendMessage("§b§l---"+ot.getName()+"`s Data ---");
				p.sendMessage("§6IP: §7" + DataConfig.getIP(ot.getUniqueId().toString()));
				p.sendMessage("§6Port: §7" + DataConfig.getPort(ot.getUniqueId().toString()));
				p.sendMessage("§6Last Time Played: §7" + DataConfig.getLastPlayedDate(ot.getUniqueId().toString()));
				p.sendMessage("§6Country: §7" + IPManager.getCountry(DataConfig.getIP(ot.getUniqueId().toString())));
				p.sendMessage("§6Region: §7" + IPManager.getRegion(DataConfig.getIP(ot.getUniqueId().toString())));
				p.sendMessage("§6City: §7" + IPManager.getCity(DataConfig.getIP(ot.getUniqueId().toString())));
				p.sendMessage("§b§l----------------------");
			} else {
				p.sendMessage("§c/getdata <playername>");
			}
			} else {
				p.sendMessage("§cNo permissions!");
			}
		} else {
			if(args.length == 1) {
				ProxiedPlayer t = ProxyServer.getInstance().getPlayer(args[0]);
				BungeecordOfflinePlayer ot = new BungeecordOfflinePlayer(args[0]);
				if(!DataConfig.isRegistered(ot.getUniqueId().toString())) {
					DataLogger.getConsole().sendMessage("§cPlayer not found!");
					return;
				}
				DataLogger.getConsole().sendMessage("§b§l---"+ot.getName()+"`s Data ---");
				DataLogger.getConsole().sendMessage("§6IP: §7" + DataConfig.getIP(ot.getUniqueId().toString()));
				DataLogger.getConsole().sendMessage("§6Port: §7" + DataConfig.getPort(ot.getUniqueId().toString()));
				DataLogger.getConsole().sendMessage("§6Last Time Played: §7" + DataConfig.getLastPlayedDate(ot.getUniqueId().toString()));
				DataLogger.getConsole().sendMessage("§6Country: §7" + IPManager.getCountry(DataConfig.getIP(ot.getUniqueId().toString())));
				DataLogger.getConsole().sendMessage("§6Region: §7" + IPManager.getRegion(DataConfig.getIP(ot.getUniqueId().toString())));
				DataLogger.getConsole().sendMessage("§6City: §7" + IPManager.getCity(DataConfig.getIP(ot.getUniqueId().toString())));
				DataLogger.getConsole().sendMessage("§b§l----------------------");
			} else {
				DataLogger.getConsole().sendMessage("§cgetdata <playername>");
			}
		}
		
		/**
		 * MaximDe 2022.
		 * 
		 * LINKS:
		 * https://github.com/JavaDevMC
		 * https://www.spigotmc.org/members/maximde.1620695/
		 */

	}

}
