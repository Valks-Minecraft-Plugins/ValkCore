package me.valk.valkcore;

import me.valk.valkcore.gui.GUIListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * ValkCore
 */
public class ValkCore extends JavaPlugin {
	@Override
	public void onEnable() {
		registerListeners();
	}

	private void registerListeners() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new GUIListener(), this);
	}
}
