package com.valkcore.color;

import net.md_5.bungee.api.ChatColor;

public class Color {
	private static String primaryColor = "&f";
	private static String secondaryColor = "&7";
	
	public static String convertToColor(String message) {
		message = message.replaceAll("&q", primaryColor);
		message = message.replaceAll("&w", secondaryColor);
		return ChatColor.translateAlternateColorCodes('&', secondaryColor + message);
	}
}
