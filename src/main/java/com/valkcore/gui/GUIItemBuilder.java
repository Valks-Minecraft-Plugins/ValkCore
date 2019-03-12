package com.valkcore.gui;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import com.valkcore.modules.ItemModule;

public class GUIItemBuilder extends GUI {
	public static Map<UUID, GUIItemBuilder> invItemBuilder = new HashMap<UUID, GUIItemBuilder>();
	private ItemStack item;
	private Material material;
	
	public GUIItemBuilder(Player p) {
		material = Material.BEEF;
		item = new ItemStack(material);
		invItemBuilder.put(p.getUniqueId(), this);
	}
	
	public Inventory getInv() {
		Inventory inv = Bukkit.createInventory(null, 54, "Item Builder");
		inv.setItem(0, ItemModule.item("&fSelect Material", "&7Materials", Material.FEATHER));
		inv.setItem(1, ItemModule.item("&fSelect ItemFlags", "&7Item Flags", Material.IRON_NUGGET));
		
		inv.setItem(22, item);
		return inv;
	}
	
	public void setMaterial(Material material) {
		item.setType(material);
	}
	
	public void addFlag(ItemFlag flag) {
		item.getItemMeta().addItemFlags(flag);
	}
	
	public void removeFlag(ItemFlag flag) {
		item.getItemMeta().removeItemFlags(flag);
	}
	
	public ItemStack getItem() {
		return item;
	}
}
