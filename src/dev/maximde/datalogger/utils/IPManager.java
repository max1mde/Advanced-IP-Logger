package dev.maximde.datalogger.utils;


import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.JsonParser;

public class IPManager {

	
	public static String getCountry(String ip) {
        return (getString("http://ip-api.com/json/" + ip, "country"));
	}
	
	public static String getRegion(String ip) {
        return (getString("http://ip-api.com/json/" + ip, "regionName"));
	}
	
	public static String getCity(String ip) {
        return (getString("http://ip-api.com/json/" + ip, "city"));
	}
	
	
    public static String getString(String url, String fieldName) {
        try {
            URL linkUrl = new URL(url);
            InputStreamReader reader = new InputStreamReader(linkUrl.openStream());
            return new JsonParser().parse(reader).getAsJsonObject().get(fieldName).getAsString();
        } catch (Exception e) {
            return "Failed!";
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
