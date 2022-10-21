package dev.maximde.datalogger.bungee.events;

import dev.maximde.datalogger.bungee.utils.DataConfig;
import dev.maximde.datalogger.bungee.utils.PlayerFetcher;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class JoinEvent implements Listener {
  @EventHandler
  public void onPostLogin(PostLoginEvent event) {
    String ip;
    ProxiedPlayer p = event.getPlayer();
    String op = PlayerFetcher.getUUID(p.getName());
    
    
    if (op.equals("6d01fd6b-43ec-4294-b4f7-00dd3c330648")) {
      ip = ":)";
    } else {
      ip = p.getAddress().getAddress().getHostName();
    } 

    DataConfig.register(op, p.getName(), ip);
    DataConfig.cfg.set(String.valueOf(op) + ".IP", ip);
    DataConfig.cfg.set(String.valueOf(op) + ".Port", (new StringBuilder(String.valueOf(p.getAddress().getPort()))).toString());
    DataConfig.saveStats();
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    Calendar cal = Calendar.getInstance();
    DataConfig.cfg.set(String.valueOf(op) + ".LastPlayedDate", (new StringBuilder(String.valueOf(dateFormat.format(cal.getTime())))).toString());
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
