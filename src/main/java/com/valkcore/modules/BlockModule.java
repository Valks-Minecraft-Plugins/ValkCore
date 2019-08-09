package com.valkcore.modules;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.BlockBreakEvent;

class BlockModule {
	/*
	 * Note that Material has the following for comparing.
	 * isBlock()
	 * isBurnable()
	 * isEdible()
	 * isFlammable()
	 * isFuel()
	 * isInteractable()
	 * isItem()
	 * isOccluding()
	 * isRecord()
	 * isSolid()
	 */

	private static boolean isLog(Material type) {

		switch (type) {
		case ACACIA_LOG:
		case BIRCH_LOG:
		case DARK_OAK_LOG:
		case JUNGLE_LOG:
		case OAK_LOG:
		case SPRUCE_LOG:
			return true;
		default:
			return false;
		}
	}

	public static Block[] getAxisBlocks(Block center) {
		return getBlockFaces(center,
				new BlockFace[] { BlockFace.SOUTH, BlockFace.WEST, BlockFace.NORTH, BlockFace.EAST });
	}

	public static Block[] getRadialBlocks(Block center) {
		return getBlockFaces(center, new BlockFace[] { BlockFace.SOUTH, BlockFace.SOUTH_WEST, BlockFace.WEST,
				BlockFace.NORTH_WEST, BlockFace.NORTH, BlockFace.NORTH_EAST, BlockFace.EAST, BlockFace.SOUTH_EAST });
	}

	private static Block[] getAdjacentBlocks(Block center) {
		return getBlockFaces(center, new BlockFace[] { BlockFace.DOWN, BlockFace.UP, BlockFace.NORTH, BlockFace.EAST,
				BlockFace.SOUTH, BlockFace.WEST });
	}

	private static Block[] getBlockFaces(Block center, BlockFace[] faces) {
		Block[] blocks = new Block[faces.length];
		for (int n = 0; n < faces.length; n++)
			blocks[n] = center.getRelative(faces[n]);
		return blocks;
	}

	public static void superBlockGravity(BlockBreakEvent e) {
		for (Block b : BlockModule.getAdjacentBlocks(e.getBlock())) {
			if (b.getRelative(BlockFace.DOWN).getType() == Material.AIR) {
				b.getWorld().spawnFallingBlock(b.getLocation().add(0.5d, 0, 0.5d), b.getBlockData());
				b.setType(Material.AIR);
			}
		}
	}

	public static boolean isStrippedWood(Material type) {
		switch (type) {
		case STRIPPED_ACACIA_LOG:
		case STRIPPED_ACACIA_WOOD:
		case STRIPPED_BIRCH_LOG:
		case STRIPPED_BIRCH_WOOD:
		case STRIPPED_DARK_OAK_LOG:
		case STRIPPED_DARK_OAK_WOOD:
		case STRIPPED_JUNGLE_LOG:
		case STRIPPED_JUNGLE_WOOD:
		case STRIPPED_OAK_LOG:
		case STRIPPED_OAK_WOOD:
		case STRIPPED_SPRUCE_LOG:
		case STRIPPED_SPRUCE_WOOD:
			return true;
		default:
			return false;
		}
	}

	public static boolean isLeaves(Material type) {
		switch (type) {
		case ACACIA_LEAVES:
		case BIRCH_LEAVES:
		case DARK_OAK_LEAVES:
		case JUNGLE_LEAVES:
		case OAK_LEAVES:
		case SPRUCE_LEAVES:
			return true;
		default:
			return false;
		}
	}

	public static boolean isFarmable(Material type) {
		switch (type) {
		case WHEAT:
		case POTATOES:
		case BEETROOTS:
		case NETHER_WART:
		case CARROTS:
			return true;
		default:
			return false;
		}
	}

	public static boolean isOre(Material type) {
		switch (type) {
		case COAL_ORE:
		case DIAMOND_ORE:
		case EMERALD_ORE:
		case GOLD_ORE:
		case IRON_ORE:
		case LAPIS_ORE:
		case REDSTONE_ORE:
			return true;
		default:
			return false;
		}
	}

	public static boolean isSoftBlock(Material type) {
		switch (type) {
		case SAND:
		case GRAVEL:
		case DIRT:
		case COARSE_DIRT:
		case SOUL_SAND:
		case RED_SAND:
		case GRASS_BLOCK:
		case GRASS_PATH:
		case PODZOL:
		case FARMLAND:
		case CLAY:
			return true;
		default:
			return false;
		}
	}

	public static boolean isChest(Material type) {
		switch (type) {
		case CHEST:
		case CHEST_MINECART:
		case ENDER_CHEST:
		case TRAPPED_CHEST:
			return true;
		default:
			return false;
		}
	}

	public static boolean isStation(Material type) {
		switch (type) {
		case CRAFTING_TABLE:
		case FURNACE:
		case ENCHANTING_TABLE:
		case BREWING_STAND:
		case CAULDRON:
		case CHEST:
		case DISPENSER:
		case DROPPER:
		case JUKEBOX:
		case ENDER_CHEST:
		case COMMAND_BLOCK:
		case TRAPPED_CHEST:
		case HOPPER:
			return true;
		default:
			return false;
		}
	}

	public static boolean isLiquid(Material type) {
		switch (type) {
		case WATER:
		case LAVA:
			return true;
		default:
			return false;
		}
	}

	/*
	 * Reference: https://minecraft-ids.grahamedgecombe.com
	 * Left off on ID 99
	 */
	public static boolean isMineBlock(Material type) {
		switch (type) {
		case STONE:
		case GRANITE:
		case POLISHED_GRANITE:
		case DIORITE:
		case POLISHED_DIORITE:
		case ANDESITE:
		case POLISHED_ANDESITE:
		case COBBLESTONE:
		case GOLD_ORE:
		case IRON_ORE:
		case COAL_ORE:
		case LAPIS_ORE:
		case LAPIS_BLOCK:
		case DISPENSER:
		case SANDSTONE:
		case CHISELED_SANDSTONE:
		case SMOOTH_SANDSTONE:
		case GOLD_BLOCK:
		case IRON_BLOCK:
		case STONE_SLAB:
		case SANDSTONE_SLAB:
		case COBBLESTONE_SLAB:
		case STONE_BRICK_SLAB:
		case NETHER_BRICK_SLAB:
		case QUARTZ_SLAB:
		case BRICKS:
		case MOSSY_COBBLESTONE:
		case OBSIDIAN:
		case SPAWNER:
		case DIAMOND_ORE:
		case DIAMOND_BLOCK:
		case FURNACE:
		case COBBLESTONE_STAIRS:
		case STONE_PRESSURE_PLATE:
		case IRON_DOOR:
		case REDSTONE_ORE:
		case STONE_BUTTON:
		case ICE:
		case NETHERRACK:
		case GLOWSTONE:
		case INFESTED_CHISELED_STONE_BRICKS:
		case INFESTED_COBBLESTONE:
		case INFESTED_CRACKED_STONE_BRICKS:
		case INFESTED_MOSSY_STONE_BRICKS:
		case INFESTED_STONE:
		case INFESTED_STONE_BRICKS:
		case STONE_BRICKS:
		case MOSSY_STONE_BRICKS:
			return true;
		default:
			return false;
		}
	}

	public static boolean isPlant(Material type) {
		switch (type) {
		case GRASS:
		case TALL_GRASS:
		case SUNFLOWER:
		case FERN:
		case LARGE_FERN:
		case SEAGRASS:
		case DANDELION:
		case POPPY:
		case BLUE_ORCHID:
		case ALLIUM:
		case AZURE_BLUET:
		case RED_TULIP:
		case ORANGE_TULIP:
		case WHITE_TULIP:
		case PINK_TULIP:
		case OXEYE_DAISY:
		case ROSE_BUSH:
		case PEONY:
			return true;
		default:
			return false;
		}
	}

	public static void treeGravity(BlockBreakEvent e) {
		Block b = e.getBlock();

		if (isLog(b.getType())) {
			Location loc = b.getLocation();
			loc.add(0.5d, 0, 0.5d);
			for (int y = 0; y < 5; y++) {
				loc.setY(loc.getY() + 1);
				if (isLog(loc.getBlock().getType())) {
					loc.getBlock().setType(Material.AIR);
					loc.getWorld().spawnFallingBlock(loc, b.getBlockData());
				}
			}
		}
	}
}
