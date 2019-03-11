package com.valkcore.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvNavListener implements Listener {
	@EventHandler
	private void invClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		InvNav invNav = InvNav.invNav.get(p.getUniqueId());
		if (e.getView().getTitle().equalsIgnoreCase(invNav.getTitle())) {
			e.setCancelled(true);
			if (e.getSlot() == invNav.getNextPageSlot()) {
				invNav.nextPage();
			}
			
			if (e.getSlot() == invNav.getPrevPageSlot()) {
				invNav.prevPage();
			}
			
			if (e.getSlot() == invNav.getBackSlot()) {
				invNav.closeInv();
			}
		}
	}
}
