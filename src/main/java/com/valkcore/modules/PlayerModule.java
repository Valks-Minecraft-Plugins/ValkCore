package com.valkcore.modules;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@SuppressWarnings("ALL")
class PlayerModule {
	public static void addPotionEffect(Player p, PotionEffectType type, int duration, int level) {
		if (!p.hasPotionEffect(type)) {
			p.addPotionEffect(new PotionEffect(type, duration, level));
		}
	}

	@SuppressWarnings("deprecation")
	public static void fillPlayerHealth(Player p) {
		p.setHealth(p.getMaxHealth());
	}

	public static void fillPlayerFood(Player p) {
		p.setFoodLevel(20 + 6); // 6 is for more saturation.
	}

	public static boolean inSurvival(Player p) {
		return p.getGameMode() == GameMode.SURVIVAL;
	}

	public static void removeAllPotionEffects(Player p) {
		for (PotionEffect effect : p.getActivePotionEffects()) {
			p.removePotionEffect(effect.getType());
		}
	}
}
