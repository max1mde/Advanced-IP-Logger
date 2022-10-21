package dev.maximde.datalogger.bungee.commands;

import java.util.ArrayList;
import java.util.List;

import dev.maximde.datalogger.bungee.utils.BungeecordOfflinePlayer;
import dev.maximde.datalogger.bungee.utils.DataConfig;
import dev.maximde.datalogger.bungee.DataLogger;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;


public class ListAltAccounts extends Command {
	

	public ListAltAccounts(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer)sender;
			if(p.hasPermission("advancedlogger.getalts")) {
			if(args.length == 1) {
								ProxiedPlayer t = ProxyServer.getInstance().getPlayer(args[0]);
								BungeecordOfflinePlayer ot = new BungeecordOfflinePlayer(args[0]);
								if(!DataConfig.isRegistered(ot.getUniqueId().toString())) {
									p.sendMessage("§cPlayer not found!");
									return;
								}
								List<String> altAccounts = new ArrayList<>();
								altAccounts.clear();
								for(String key : DataConfig.cfg.getKeys(false)) {
									if(DataConfig.cfg.getString(key+".IP").equals(DataConfig.getIP(ot.getUniqueId().toString()))) {
										if(!DataConfig.cfg.getString(key+".Name").equals(t.getName())) {
											altAccounts.add(DataConfig.cfg.getString(key+".Name"));
										}
									}
								}
								if(altAccounts.isEmpty()) {
									p.sendMessage("§cNo alt account for player: " + ot.getName() + " found!");
								} else {
									p.sendMessage("§aAlt accounts of " + ot.getName()+ ":");
									for(String altAccName : altAccounts) {
										p.sendMessage(altAccName);
									}
									p.sendMessage("§a--------------------");
								}
			} else {
				p.sendMessage("§c/getalts <playername>");
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
				List<String> altAccounts = new ArrayList<>();
				altAccounts.clear();
				for(String key : DataConfig.cfg.getKeys(false)) {
					if(DataConfig.cfg.getString(key+".IP").equals(DataConfig.getIP(ot.getUniqueId().toString()))) {
						if(!DataConfig.cfg.getString(key+".Name").equals(ot.getName())) {
							altAccounts.add(DataConfig.cfg.getString(key+".Name"));
						}
					}
				}
				if(altAccounts.isEmpty()) {
					DataLogger.getConsole().sendMessage("§cNo alt account for player: " + ot.getName() + " found!");
				} else {
					DataLogger.getConsole().sendMessage("§aAlt accounts of " + ot.getName()+ ":");
					for(String altAccName : altAccounts) {
						DataLogger.getConsole().sendMessage(altAccName);
					}
					DataLogger.getConsole().sendMessage("§a--------------------");
				}
			} else {
				DataLogger.getConsole().sendMessage("§cgetalts <playername>");
			}
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
