package dev.maximde.datalogger.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.maximde.datalogger.utils.DataConfig;
import dev.maximde.datalogger.utils.IPManager;


public class GetData implements CommandExecutor {
	

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.hasPermission("getdata.cmd")) {
			if(args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
				if(t == null) {
					OfflinePlayer ot = Bukkit.getOfflinePlayer(args[0]);
					if(!DataConfig.isRegistered(ot.getUniqueId().toString())) {
						p.sendMessage("§cPlayer not found!");
						return false;
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
					if(!DataConfig.isRegistered(t.getUniqueId().toString())) {
						p.sendMessage("§cPlayer not found!");
						return false;
					}
					p.sendMessage("§b§l---"+t.getName()+"`s Data ---");
					p.sendMessage("§6IP: §7" + DataConfig.getIP(t.getUniqueId().toString()));
					p.sendMessage("§6Port: §7" + DataConfig.getPort(t.getUniqueId().toString()));
					p.sendMessage("§6Last Time Played: §7" + DataConfig.getLastPlayedDate(t.getUniqueId().toString()));
					p.sendMessage("§6Country: §7" + IPManager.getCountry(DataConfig.getIP(t.getUniqueId().toString())));
					p.sendMessage("§6Region: §7" + IPManager.getRegion(DataConfig.getIP(t.getUniqueId().toString())));
					p.sendMessage("§6City: §7" + IPManager.getCity(DataConfig.getIP(t.getUniqueId().toString())));
					p.sendMessage("§b§l----------------------");
				}
			} else {
				p.sendMessage("§c/getdata <playername>");
			}
			} else {
				p.sendMessage("§cNo permissions!");
			}
		} else {
			if(args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
			if(t == null) {
				OfflinePlayer ot = Bukkit.getOfflinePlayer(args[0]);
				if(!DataConfig.isRegistered(ot.getUniqueId().toString())) {
					org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§cPlayer not found!");
					return false;
				}
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§b§l---"+ot.getName()+"`s Data ---");
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§6IP: §7" + DataConfig.getIP(ot.getUniqueId().toString()));
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§6Port: §7" + DataConfig.getPort(ot.getUniqueId().toString()));
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§6Last Time Played: §7" + DataConfig.getLastPlayedDate(ot.getUniqueId().toString()));
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§6Country: §7" + IPManager.getCountry(DataConfig.getIP(ot.getUniqueId().toString())));
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§6Region: §7" + IPManager.getRegion(DataConfig.getIP(ot.getUniqueId().toString())));
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§6City: §7" + IPManager.getCity(DataConfig.getIP(ot.getUniqueId().toString())));
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§b§l----------------------");
			} else {
				if(!DataConfig.isRegistered(t.getUniqueId().toString())) {
					org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§cPlayer not found!");
					return false;
				}
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§b§l---"+t.getName()+"`s Data ---");
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§6IP: §7" + DataConfig.getIP(t.getUniqueId().toString()));
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§6Port: §7" + DataConfig.getPort(t.getUniqueId().toString()));
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§6Last Time Played: §7" + DataConfig.getLastPlayedDate(t.getUniqueId().toString()));
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§6Country: §7" + IPManager.getCountry(DataConfig.getIP(t.getUniqueId().toString())));
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§6Region: §7" + IPManager.getRegion(DataConfig.getIP(t.getUniqueId().toString())));
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§6City: §7" + IPManager.getCity(DataConfig.getIP(t.getUniqueId().toString())));
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§b§l----------------------");
			}
			} else {
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§cgetdata <playername>");
			}
		}
		return true;
	}

	/**
	 * MaximDe 2022.
	 * 
	 * LINKS:
	 * https://github.com/JavaDevMC
	 * https://www.spigotmc.org/members/maximde.1620695/
	 */
}
