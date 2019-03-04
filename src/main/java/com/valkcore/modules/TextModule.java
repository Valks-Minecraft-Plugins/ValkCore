package com.valkcore.modules;

import net.md_5.bungee.api.ChatColor;

public class TextModule {
	private static String primaryColor = "&f";
	private static String secondaryColor = "&7";
	
	public static String color(String message) {
		message = message.replaceAll("&q", primaryColor);
		message = message.replaceAll("&w", secondaryColor);
		return ChatColor.translateAlternateColorCodes('&', secondaryColor + message);
	}
}
