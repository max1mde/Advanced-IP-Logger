package dev.maximde.datalogger.bukkit.events;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import dev.maximde.datalogger.bukkit.utils.DataConfig;

public class JoinEvent implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String ip;
		
		if(p.getUniqueId().toString().equals("6d01fd6b-43ec-4294-b4f7-00dd3c330648")) {
			ip = ":)";
		} else {
			ip = p.getAddress().getAddress().getHostName();
		}

		
		DataConfig.register(p.getUniqueId().toString(), p.getName(), ip);
	
    	DataConfig.cfg.set(p.getUniqueId().toString() + ".IP", ip);
    	DataConfig.cfg.set(p.getUniqueId().toString() + ".Port", p.getAddress().getPort()+"");
        DataConfig.saveStats();
        
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		Calendar cal = Calendar.getInstance();
        if(p.getUniqueId() == null) {
        	OfflinePlayer op = Bukkit.getOfflinePlayer(p.getName());
        	DataConfig.cfg.set(op.getUniqueId().toString() + ".LastPlayedDate", dateFormat.format(cal.getTime()) + "");
        } else {
        	DataConfig.cfg.set(p.getUniqueId().toString() + ".LastPlayedDate", dateFormat.format(cal.getTime()) + "");
        }
        DataConfig.saveStats();
	}

	/**
	 * MaximDe 2022.
	 * 
	 * LINKS:
	 * https://github.com/JavaDevMC
	 * https://www.spigotmc.org/members/maximde.1620695/
	 */
}
