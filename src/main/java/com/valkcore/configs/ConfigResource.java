package com.valkcore.configs;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigResource {
	protected ConfigManager cm;
	protected YamlConfiguration config;

	public ConfigResource(ConfigManager cm) {
		this.cm = cm;
		this.config = cm.getConfig();
	}
	
	protected void setConfigResource(String path) {
		config.set(path, null);
	}
}
