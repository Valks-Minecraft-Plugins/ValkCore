package com.valkcore.gui;

import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvListener implements Listener {
	@EventHandler
	private void invClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		String viewTitle = e.getView().getTitle();
		int slot = e.getSlot();
		
		Map<UUID, InvNav> invNavs = InvNav.invNav;
		
		/*Map<UUID, InvItemBuilder> invItemBuilders = InvItemBuilder.invItemBuilder;
		
		if (invItemBuilders.size() != 0) {
			InvItemBuilder invItemBuilder = InvItemBuilder.invItemBuilder.get(p.getUniqueId());
			
			if (viewTitle.equalsIgnoreCase("Item Builder")) {
				e.setCancelled(true);
				if (slot == 0) {
					// select materials
					List<ItemStack> items = new ArrayList<ItemStack>();
					for (Material mat : Material.values()) {
						if (mat.isItem())
							items.add(new ItemStack(mat));
					}
					new InvNav(p, items, 6, "Materials").openInv();
				}
			}
		}*/
		
		if (invNavs.size() != 0) {
			InvNav invNav = InvNav.invNav.get(p.getUniqueId());
			
			if (viewTitle.equalsIgnoreCase(invNav.getTitle())) {
				e.setCancelled(true);
				if (slot < invNav.getSize() - 9) {
					// Bukkit.getPluginManager().callEvent(new NavClickEvent(p));
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
