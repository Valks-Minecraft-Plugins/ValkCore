package me.valk.valkcore.gui;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUI {
	public void fill(Inventory inv, ItemStack item, boolean force) {
		for (int i = 0; i < inv.getSize(); i++) {
			if (force)
				inv.setItem(i, item);
			else {
				if (inv.getItem(i) == null)
					inv.setItem(i, item);
			}
		}
	}

	public ItemStack findItem(ItemStack item) {
		return null;
	}
}
