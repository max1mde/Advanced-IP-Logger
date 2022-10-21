package dev.maximde.datalogger.bungee.events;

import dev.maximde.datalogger.bungee.utils.DataConfig;
import dev.maximde.datalogger.bungee.utils.PlayerFetcher;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class QuitEvent implements Listener {
  @EventHandler
  public void onQuit(PlayerDisconnectEvent e) {
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    Calendar cal = Calendar.getInstance();
    ProxiedPlayer p = e.getPlayer();
    String op = PlayerFetcher.getUUID(p.getName());
    DataConfig.cfg.set(String.valueOf(op) + ".LastPlayedDate", (new StringBuilder(String.valueOf(dateFormat.format(cal.getTime())))).toString());
    DataConfig.saveStats();
  }
}
