package com.valkcore;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.valkcore.gui.GUIListener;

public class ValkCore extends JavaPlugin {

	@Override
	public void onEnable() {
		ValkCore plugin = this;
		registerListeners();
	}

	private void registerListeners() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new GUIListener(), this);
	}
}
