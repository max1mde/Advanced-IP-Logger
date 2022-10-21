package dev.maximde.datalogger.bukkit.events;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import dev.maximde.datalogger.bukkit.utils.DataConfig;

public class QuitEvent implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		Calendar cal = Calendar.getInstance();
        Player p = e.getPlayer();
        if(p.getUniqueId() == null) {
        	OfflinePlayer op = Bukkit.getOfflinePlayer(p.getName());
        	DataConfig.cfg.set(op.getUniqueId().toString() + ".LastPlayedDate", dateFormat.format(cal.getTime()) + "");
        } else {
        	DataConfig.cfg.set(p.getUniqueId().toString() + ".LastPlayedDate", dateFormat.format(cal.getTime()) +"");
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
