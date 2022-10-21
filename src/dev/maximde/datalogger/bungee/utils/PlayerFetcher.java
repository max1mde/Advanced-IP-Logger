package dev.maximde.datalogger.bungee.utils;



public class PlayerFetcher {

	public static String getUUID(String name) {
		java.util.UUID id = java.util.UUID.fromString (IPManager.getString("https://api.mojang.com/users/profiles/minecraft/" + name, "id").replaceFirst ("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)","$1-$2-$3-$4-$5"));
		return id.toString();
	}
	
	public static String getName(String uuid) {
		return IPManager.getString("https://api.mojang.com/users/profiles/minecraft/" + uuid, "name");
	}
	
	/**
	 * MaximDe 2022.
	 * 
	 * LINKS:
	 * https://github.com/JavaDevMC
	 * https://www.spigotmc.org/members/maximde.1620695/
	 */
}