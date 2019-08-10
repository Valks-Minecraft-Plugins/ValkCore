package me.valk.valkcore.modules;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class ItemModule {
	public static ItemStack item(String name, String lore, Material material) {
		ItemStack item = new ItemStack(material);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(ChatColor.WHITE + TextModule.color(name));
		im.addItemFlags(ItemFlag.values());
		List<String> list = new ArrayList<>();
		for (String element : lore.split("\n")) {
			list.add(ChatColor.GRAY + TextModule.color(element));
		}
		im.setLore(list);
		item.setItemMeta(im);
		return item;
	}

	public static ItemStack tool(String name, String lore, Material material) {
		ItemStack item = new ItemStack(material, 1);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(ChatColor.WHITE + TextModule.color(name));
		im.addItemFlags(ItemFlag.values());
		List<String> list = new ArrayList<>();
		for (String element : lore.split("\n")) {
			list.add(ChatColor.GRAY + TextModule.color(element));
		}
		im.setLore(list);
		item.setItemMeta(im);
		return item;
	}

	public static ItemStack potion(String name, String lore, PotionType potionType) {
		ItemStack potion = new ItemStack(Material.POTION);
		PotionMeta pm = (PotionMeta) potion.getItemMeta();
		pm.setDisplayName(name);
		pm.setBasePotionData(new PotionData(potionType));
		pm.addItemFlags(ItemFlag.values());
		List<String> list = new ArrayList<>();
		for (String element : lore.split("\n")) {
			list.add(ChatColor.GRAY + TextModule.color(element));
		}
		pm.setLore(list);
		potion.setItemMeta(pm);
		return potion;
	}

	public static ItemStack splashPotion(String name, String lore, PotionType potionType) {
		ItemStack potion = new ItemStack(Material.SPLASH_POTION);
		PotionMeta pm = (PotionMeta) potion.getItemMeta();
		pm.setDisplayName(name);
		pm.setBasePotionData(new PotionData(potionType));
		pm.addItemFlags(ItemFlag.values());
		List<String> list = new ArrayList<>();
		for (String element : lore.split("\n")) {
			list.add(ChatColor.GRAY + TextModule.color(element));
		}
		pm.setLore(list);
		potion.setItemMeta(pm);
		return potion;
	}
}
