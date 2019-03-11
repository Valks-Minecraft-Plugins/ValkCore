package com.valkcore;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.valkcore.gui.InvNavListener;

public class ValkCore extends JavaPlugin {
	public static ValkCore plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		registerListeners();
	}
	
	private void registerListeners() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new InvNavListener(), this);
	}
}
