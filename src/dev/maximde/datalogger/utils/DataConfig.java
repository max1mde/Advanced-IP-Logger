package dev.maximde.datalogger.utils;

import java.io.File;
import java.io.IOException;


import org.bukkit.configuration.file.YamlConfiguration;


public class DataConfig {
	
	/**
	 * Config file
	 */
	public static File f = new File("plugins/AdvancedIPLogger", "data.yml");

	/**
	 * YAML config
	 */
	public static YamlConfiguration cfg = new YamlConfiguration().loadConfiguration(f);
	
	public static boolean isRegistered(String uuid) {
		return cfg.contains(uuid);
	}
	
	public static void saveStats() {
		try {
			cfg.save(f);
		} catch (IOException e) {
			System.err.println("[DataLogger] Saving stats FAILED!");
			e.printStackTrace();
		}
		
	}
	

	public static void reloadStats() {
		cfg = new YamlConfiguration().loadConfiguration(f);
	}
	

	public static void register(String player_uuid, String player_name, String ip) {
		if(!isRegistered(player_uuid)) {
			cfg.set(player_uuid + ".Name", player_name);
			cfg.set(player_uuid + ".IP", ip);
			cfg.set(player_uuid + ".Port", "");
			cfg.set(player_uuid + ".LastPlayedDate", "");
			saveStats();
		}
	}

	public static String getName(String uuid) {
		return cfg.getString(uuid + ".Name");
	}
	
	public static String getLastPlayedDate(String uuid) {
		return cfg.getString(uuid + ".LastPlayedDate");
	}
	
	public static String getIP(String uuid) {
		return cfg.getString(uuid + ".IP");
	}
	
	public static String getPort(String uuid) {
		return cfg.getString(uuid + ".Port");
	}

	/**
	 * MaximDe 2022.
	 * 
	 * LINKS:
	 * https://github.com/JavaDevMC
	 * https://www.spigotmc.org/members/maximde.1620695/
	 */
}
