package com.valkcore.modules;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import com.valkcore.ValkCore;
import com.vinkaitems.VinkaItem;
import com.vinkaitems.VinkaItems;

public class ItemModule {
	public static List<Inventory> translatedHandRecipes = new ArrayList<Inventory>();
	public static List<Inventory> translatedCraftingRecipes = new ArrayList<Inventory>();
	public static List<Inventory> translatedFurnaceRecipes = new ArrayList<Inventory>();
	public static List<Inventory> translatedShapelessRecipes = new ArrayList<Inventory>();

	public static List<ItemStack> handRecipeItems = new ArrayList<ItemStack>();
	public static List<ItemStack> craftingRecipeItems = new ArrayList<ItemStack>();
	public static List<ItemStack> furnaceRecipeItems = new ArrayList<ItemStack>();
	public static List<ItemStack> shapelessRecipeItems = new ArrayList<ItemStack>();

	public static List<Inventory> handNavigation = new ArrayList<Inventory>();
	public static List<Inventory> craftingNavigation = new ArrayList<Inventory>();
	public static List<Inventory> furnaceNavigation = new ArrayList<Inventory>();
	public static List<Inventory> shapelessNavigation = new ArrayList<Inventory>();
	
	public static void shapelessRecipeHomeInv() {
		Inventory inv = null;
		final int breakEach = 45;
		for (int i = 0; i < shapelessRecipeItems.size(); i++) {
			if (i % breakEach == 0) {
				inv = Bukkit.createInventory(null, 9 * 6, "Shapeless Recipe Navigation");
				inv.setItem(45, ItemModule.item("Previous", "Flip a page.", Material.BLACK_STAINED_GLASS_PANE));
				inv.setItem(49, ItemModule.item("Back", "Go back a page.", Material.BLACK_STAINED_GLASS_PANE));
				inv.setItem(53, ItemModule.item("Next", "Flip a page.", Material.BLACK_STAINED_GLASS_PANE));
				shapelessNavigation.add(inv);
			}
			inv.setItem(i % breakEach, shapelessRecipeItems.get(i));
		}
	}
	
	public static void furnaceRecipeHomeInv() {
		Inventory inv = null;
		final int breakEach = 45;
		for (int i = 0; i < furnaceRecipeItems.size(); i++) {
			if (i % breakEach == 0) {
				inv = Bukkit.createInventory(null, 9 * 6, "Furnace Recipe Navigation");
				inv.setItem(45, ItemModule.item("Previous", "Flip a page.", Material.BLACK_STAINED_GLASS_PANE));
				inv.setItem(49, ItemModule.item("Back", "Go back a page.", Material.BLACK_STAINED_GLASS_PANE));
				inv.setItem(53, ItemModule.item("Next", "Flip a page.", Material.BLACK_STAINED_GLASS_PANE));
				furnaceNavigation.add(inv);
			}
			inv.setItem(i % breakEach, furnaceRecipeItems.get(i));
		}
	}
	
	public static void craftingRecipeHomeInv() {
		Inventory inv = null;
		final int breakEach = 45;
		for (int i = 0; i < craftingRecipeItems.size(); i++) {
			if (i % breakEach == 0) {
				inv = Bukkit.createInventory(null, 9 * 6, "Crafting Recipe Navigation");
				inv.setItem(45, ItemModule.item("Previous", "Flip a page.", Material.BLACK_STAINED_GLASS_PANE));
				inv.setItem(49, ItemModule.item("Back", "Go back a page.", Material.BLACK_STAINED_GLASS_PANE));
				inv.setItem(53, ItemModule.item("Next", "Flip a page.", Material.BLACK_STAINED_GLASS_PANE));
				craftingNavigation.add(inv);
			}
			inv.setItem(i % breakEach, craftingRecipeItems.get(i));
		}
	}
	
	/*
	 * Needs to be executed at the startup of a plugin.
	 * Prepares the hand navigation inventories.
	 */
	public static void handRecipeHomeInv() {
		Inventory inv = null;
		final int breakEach = 45;
		for (int i = 0; i < handRecipeItems.size(); i++) {
			if (i % breakEach == 0) {
				inv = Bukkit.createInventory(null, 9 * 6, "Hand Recipe Navigation");
				inv.setItem(45, ItemModule.item("Previous", "Flip a page.", Material.BLACK_STAINED_GLASS_PANE));
				inv.setItem(49, ItemModule.item("Back", "Go back a page.", Material.BLACK_STAINED_GLASS_PANE));
				inv.setItem(53, ItemModule.item("Next", "Flip a page.", Material.BLACK_STAINED_GLASS_PANE));
				handNavigation.add(inv);
			}
			inv.setItem(i % breakEach, handRecipeItems.get(i));
		}
	}
	
	public static void translateFurnaceRecipe(ItemStack result, Material required) {
		Inventory recipe = Bukkit.createInventory(null, 36, "Furnace Recipe Guide");
		recipe.setItem(0, new ItemStack(required));
		recipe.setItem(1, ItemModule.item("--->", "--->", Material.BLACK_STAINED_GLASS_PANE));
		recipe.setItem(2, result);
		recipe.setItem(18 + 9, ItemModule.item("Previous", "Flip a page.", Material.BLACK_STAINED_GLASS_PANE));
		recipe.setItem(18 + 9 + 4, ItemModule.item("Back", "Go back a page.", Material.BLACK_STAINED_GLASS_PANE));
		recipe.setItem(26 + 9, ItemModule.item("Next", "Flip a page.", Material.BLACK_STAINED_GLASS_PANE));
		translatedFurnaceRecipes.add(recipe);
	}
	
	public static void translateCraftingRecipe(ItemStack result, VinkaItem[] vinkaRequired, String shape, String ids) {
		Inventory recipe = Bukkit.createInventory(null, 36, "Crafting Recipe Guide");
		String[] the_ids = ids.split(",");
		for (int i = 0; i < the_ids.length; i++) {
			for (int n = 0; n < shape.length(); n++) {
				char c = shape.charAt(n);
				if (c == the_ids[i].charAt(0)) {
					if (n > 5) {
						recipe.setItem(n + 12, vinkaRequired[i].getItem());
					} else if (n > 2) {
						recipe.setItem(n + 6, vinkaRequired[i].getItem());
					} else {
						recipe.setItem(n, vinkaRequired[i].getItem());
					}
				}
			}
		}
		recipe.setItem(12, ItemModule.item("--->", "--->", Material.BLACK_STAINED_GLASS_PANE));
		recipe.setItem(13, result);
		recipe.setItem(18 + 9, ItemModule.item("Previous", "Flip a page.", Material.BLACK_STAINED_GLASS_PANE));
		recipe.setItem(18 + 9 + 4, ItemModule.item("Back", "Go back a page.", Material.BLACK_STAINED_GLASS_PANE));
		recipe.setItem(26 + 9, ItemModule.item("Next", "Flip a page.", Material.BLACK_STAINED_GLASS_PANE));
		translatedCraftingRecipes.add(recipe);
	}
	
	public static void translateHandRecipe(ItemStack result, VinkaItem[] vinkaRequired, String shape, String ids) {
		Inventory recipe = Bukkit.createInventory(null, 36, "Hand Recipe Guide");
		String[] the_ids = ids.split(",");
		for (int i = 0; i < the_ids.length; i++) {
			for (int n = 0; n < shape.length(); n++) {
				char c = shape.charAt(n);
				if (c == the_ids[i].charAt(0)) {
					if (n > 1) {
						recipe.setItem(n + 7, vinkaRequired[i].getItem());
					} else {
						recipe.setItem(n, vinkaRequired[i].getItem());
					}
				}
			}
		}
		recipe.setItem(2, ItemModule.item("--->", "--->", Material.BLACK_STAINED_GLASS_PANE));
		recipe.setItem(3, result);
		recipe.setItem(18 + 9, ItemModule.item("Previous", "Flip a page.", Material.BLACK_STAINED_GLASS_PANE));
		recipe.setItem(18 + 9 + 4, ItemModule.item("Back", "Go back a page.", Material.BLACK_STAINED_GLASS_PANE));
		recipe.setItem(26 + 9, ItemModule.item("Next", "Flip a page.", Material.BLACK_STAINED_GLASS_PANE));
		translatedHandRecipes.add(recipe);
	}
	
	public static void translateShapelessRecipe(ItemStack result, VinkaItem[] vinkaIngredients) {
		Inventory recipe = Bukkit.createInventory(null, 36, "Shapeless Recipe Guide");
		
		for (int i = 0; i < vinkaIngredients.length; i++) {
			if (i > 5) {
				recipe.setItem(i + 12, vinkaIngredients[i].getItem());
			} else if (i > 2) {
				recipe.setItem(i + 6, vinkaIngredients[i].getItem());
			} else {
				recipe.setItem(i, vinkaIngredients[i].getItem());
			}
		}
		recipe.setItem(12, ItemModule.item("--->", "--->", Material.BLACK_STAINED_GLASS_PANE));
		recipe.setItem(13, result);
		
		recipe.setItem(18 + 9, ItemModule.item("Previous", "Flip a page.", Material.BLACK_STAINED_GLASS_PANE));
		recipe.setItem(18 + 9 + 4, ItemModule.item("Back", "Go back a page.", Material.BLACK_STAINED_GLASS_PANE));
		recipe.setItem(26 + 9, ItemModule.item("Next", "Flip a page.", Material.BLACK_STAINED_GLASS_PANE));
		translatedShapelessRecipes.add(recipe);
	}
	
	public static void craftedRecipe(String key, VinkaItem vinkaItem, String rows, VinkaItem[] vinkaIngredients, String ids) {
		ItemStack item = vinkaItem.getItem();
		NamespacedKey namespacedKey = new NamespacedKey(ValkCore.getPlugin(ValkCore.class), key);
		ShapedRecipe recipe = new ShapedRecipe(namespacedKey, item);
		String row1 = rows.substring(0, 3);
		String row2 = rows.substring(3, 6);
		String row3 = rows.substring(6, 9);
		recipe.shape(row1, row2, row3);
		
		String[] the_ids = ids.split(",");
		
		for (int i = 0; i < vinkaIngredients.length; i++) {
			recipe.setIngredient(the_ids[i].charAt(0), vinkaIngredients[i].getItem().getType());
		}
		ValkCore.getPlugin(ValkCore.class).getServer().addRecipe(recipe);
		VinkaItems.recipes.add(new NamespacedKey(ValkCore.getPlugin(ValkCore.class), key));
		translateCraftingRecipe(item, vinkaIngredients, rows, ids);
		craftingRecipeItems.add(item);
		VinkaItems.items.add(vinkaItem);
	}
	
	public static void handRecipe(String key, VinkaItem vinkaItem, String rows, VinkaItem[] vinkaIngredients, String ids) {
		ItemStack item = vinkaItem.getItem();
		NamespacedKey namespacedKey = new NamespacedKey(ValkCore.getPlugin(ValkCore.class), key);
		ShapedRecipe recipe = new ShapedRecipe(namespacedKey, item);
		String row1 = rows.substring(0, 2);
		String row2 = rows.substring(2, 4);
		recipe.shape(row1, row2);
		
		String[] the_ids = ids.split(",");
		
		for (int i = 0; i < vinkaIngredients.length; i++) {
			recipe.setIngredient(the_ids[i].charAt(0), vinkaIngredients[i].getItem().getType());
		}
		ValkCore.getPlugin(ValkCore.class).getServer().addRecipe(recipe);
		VinkaItems.recipes.add(new NamespacedKey(ValkCore.getPlugin(ValkCore.class), key));
		translateHandRecipe(item, vinkaIngredients, rows, ids);
		handRecipeItems.add(item);
		VinkaItems.items.add(vinkaItem);
	}
	
	/*
	 * Time is in seconds.
	 */
	public static void furnaceRecipe(String key, VinkaItem vinkaResult, Material required, int time) {
		ItemStack result = vinkaResult.getItem();
		NamespacedKey nameSpacedKey = new NamespacedKey(ValkCore.getPlugin(ValkCore.class), key);
		FurnaceRecipe recipe = new FurnaceRecipe(nameSpacedKey, result, required, 0f, time * 20);
		ValkCore.getPlugin(ValkCore.class).getServer().addRecipe(recipe);
		VinkaItems.recipes.add(new NamespacedKey(ValkCore.getPlugin(ValkCore.class), key));
		translateFurnaceRecipe(result, required);
		furnaceRecipeItems.add(result);
		VinkaItems.items.add(vinkaResult);
	}
	
	public static void shapelessRecipe(String key, VinkaItem vinkaItem, VinkaItem[] vinkaIngredients) {
		ItemStack item = vinkaItem.getItem();
		NamespacedKey namespacedKey = new NamespacedKey(ValkCore.getPlugin(ValkCore.class), key);
		ShapelessRecipe recipe = new ShapelessRecipe(namespacedKey, item);
		for (VinkaItem vinkaIngredient : vinkaIngredients) {
			recipe.addIngredient(vinkaIngredient.getItem().getType());
		}
		ValkCore.getPlugin(ValkCore.class).getServer().addRecipe(recipe);
		translateShapelessRecipe(item, vinkaIngredients);
		shapelessRecipeItems.add(item);
	}
	
	public static ItemStack item(String name, String lore, Material material) {
		ItemStack item = new ItemStack(material);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(ChatColor.WHITE + TextModule.color(name));
		im.addItemFlags(ItemFlag.values());
		List<String> list = new ArrayList<String>();
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
		List<String> list = new ArrayList<String>();
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
		List<String> list = new ArrayList<String>();
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
		List<String> list = new ArrayList<String>();
		for (String element : lore.split("\n")) {
			list.add(ChatColor.GRAY + TextModule.color(element));
		}
		pm.setLore(list);
		potion.setItemMeta(pm);
		return potion;
	}
}
