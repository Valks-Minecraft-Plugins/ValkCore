package com.valkcore.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class GUIListener extends GUI implements Listener {
	@EventHandler
	private void invClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		String viewTitle = e.getView().getTitle();
		int slot = e.getSlot();

		Map<UUID, GUINavigation> invNavs = GUINavigation.invNav;

		if (viewTitle.equalsIgnoreCase("Item Builder")) {
			e.setCancelled(true);
			if (slot == 0) {
				// select materials
				List<ItemStack> items = new ArrayList<>();
				for (Material mat : Material.values()) {
					if (mat.isItem())
						items.add(new ItemStack(mat));
				}
				GUINavigation invNav = new GUINavigation(p, items, 6, "Materials");
				invNav.setItemBuilder(true);
				invNav.openInv();
			}
		}

		if (invNavs.size() != 0) {
			GUINavigation invNav = GUINavigation.invNav.get(p.getUniqueId());

			if (viewTitle.equalsIgnoreCase(invNav.getTitle())) {
				e.setCancelled(true);
				if (slot < invNav.getSize() - 9) {
					ItemStack item = invNav.getInv().getItem(e.getSlot());

					if (item != null) {
						if (invNav.isItemBuilder()) {
							Material selectedMaterial = invNav.getInv().getItem(e.getSlot()).getType();

							GUIItemBuilder invItemBuilder = GUIItemBuilder.invItemBuilder.get(p.getUniqueId());
							invItemBuilder.setMaterial(selectedMaterial);
							p.openInventory(invItemBuilder.getInv());
						}
					}
				}

				if (slot == invNav.getNextPageSlot()) {
					invNav.nextPage();
				}

				if (slot == invNav.getPrevPageSlot()) {
					invNav.prevPage();
				}

				if (slot == invNav.getBackSlot()) {
					invNav.closeInv();
				}
			}
		}
	}
}
