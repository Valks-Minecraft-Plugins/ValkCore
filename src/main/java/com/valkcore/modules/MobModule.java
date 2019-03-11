package com.valkcore.modules;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class MobModule {
	public static int countMobsInChunk(Entity[] entities, EntityType type) {
		int count = 0;
		for (Entity entity : entities) {
			if (entity.getType() == type) {
				count++;
			}
		}
		return count;
	}

	public static int countMobsInWorld(World w, EntityType type) {
		int count = 0;
		for (LivingEntity entity : w.getLivingEntities()) {
			if (entity.getType() == type) {
				count++;
			}
		}
		return count;
	}

	public static boolean isMonster(EntityType type) {
		switch (type) {
		case BLAZE:
		case CAVE_SPIDER:
		case CREEPER:
		case ELDER_GUARDIAN:
		case ENDER_DRAGON:
		case ENDERMAN:
		case ENDERMITE:
		case EVOKER:
		case GHAST:
		case GIANT:
		case GUARDIAN:
		case HUSK:
		case MAGMA_CUBE:
		case PHANTOM:
		case PIG_ZOMBIE:
		case SHULKER:
		case SILVERFISH:
		case SKELETON:
		case SLIME:
		case SPIDER:
		case STRAY:
		case VEX:
		case VINDICATOR:
		case WITCH:
		case WITHER:
		case WITHER_SKELETON:
		case ZOMBIE:
		case ZOMBIE_VILLAGER:
			return true;
		default:
			return false;
		}
	}
}
