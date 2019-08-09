package me.valk.valkcore.cooldown;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("ALL")
class Cooldown {

	private static final Map<UUID, Cooldown> cooldowns = new HashMap<>();
	private long start;
	private final int timeInSeconds;
	private final UUID id;

	public Cooldown(UUID id, int timeInSeconds) {
		this.id = id;
		this.timeInSeconds = timeInSeconds;
	}

	public static boolean isInCooldown(UUID id) {
		if (getTimeLeft(id) >= 1) {
			return true;
		} else {
			stop(id);
			return false;
		}
	}

	private static void stop(UUID id) {
		Cooldown.cooldowns.remove(id);
	}

	private static Cooldown getCooldown(UUID id) {
		return cooldowns.get(id);
	}

	private static int getTimeLeft(UUID id) {
		Cooldown cooldown = getCooldown(id);
		int f = -1;
		if (cooldown != null) {
			long now = System.currentTimeMillis();
			long cooldownTime = cooldown.start;
			int r = (int) (now - cooldownTime) / 1000;
			f = (r - cooldown.timeInSeconds) * (-1);
		}
		return f;
	}

	public void start() {
		start = System.currentTimeMillis();
		cooldowns.put(id, this);
	}

}