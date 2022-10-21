package dev.maximde.datalogger.bukkit.utils;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PlayerDataFromWeb {
	
	public static String getDiscordName(String playername) {
		String dc = "Not found!";
		

		try {
			Connection connection = Jsoup.connect("https://de.namemc.com/profile/" + playername);
			connection.userAgent("Mozilla/5.0");
			Document doc = connection.get();
			Elements element = doc.select("col d-flex flex-wrap justify-content-end justify-content-lg-start");
		    return element.attr("Discord");
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		return dc;
	}

	/**
	 * MaximDe 2022.
	 * 
	 * LINKS:
	 * https://github.com/JavaDevMC
	 * https://www.spigotmc.org/members/maximde.1620695/
	 */
}
