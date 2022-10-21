package dev.maximde.datalogger.bungee.utils;

import java.util.UUID;

public class BungeecordOfflinePlayer {

	private String name;
	private String uuid;
	
	public BungeecordOfflinePlayer(String name) {
		this.name = name;
		String uuid = PlayerFetcher.getUUID(name);
		this.uuid = uuid;
	}
	
	public String getName() {
		return this.name;
	}
	
	public UUID getUniqueId() {
		java.util.UUID id =java.util.UUID.fromString (this.uuid.replaceFirst ("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)","$1-$2-$3-$4-$5"));
		return id;
	}
	
	/**
	 * MaximDe 2022.
	 * 
	 * LINKS:
	 * https://github.com/JavaDevMC
	 * https://www.spigotmc.org/members/maximde.1620695/
	 */
}
