package com.valkcore.gui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.google.common.primitives.Ints;

public class InvNav {
	public static Map<UUID, InvNav> invNav = new HashMap<UUID, InvNav>();
	private Player p;
	private int size;
	private String title;
	private int page;
	private List<ItemStack> items;
	
	public InvNav(Player p, List<ItemStack> items, int rows, String title) {
		this.p = p;
		this.size = Ints.constrainToRange(rows, 2, 6) * 9;
		this.title = title;
		this.items = items;
		this.page = 1;
		invNav.put(p.getUniqueId(), this);
	}
	
	private Inventory getInv() {
		Inventory inv = Bukkit.createInventory(p, size, title);
		inv.setItem(size - 1, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
		inv.setItem(size - 5, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
		inv.setItem(size - 9, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
		
		final int PAGE_SIZE = size - 9;
		
		int n = PAGE_SIZE * (page - 1);
		
		for (int i = n; i < n + PAGE_SIZE; i++) {
			if (i < items.size()) {
				inv.setItem(i - n, new ItemStack(items.get(Math.min(items.size() - 1, i))));
			}
		}
		
		return inv;
	}
	
	protected void nextPage() {
		int maxPages = (int) Math.ceil(items.size() / (double) (size - 9));
		System.out.println(maxPages);
		page = Math.min(maxPages, page + 1);
		openInv();
	}
	
	protected void prevPage() {
		page = Math.max(1, page - 1);
		openInv();
	}
	
	public void openInv() {
		p.openInventory(getInv());
	}
	
	public void closeInv() {
		p.closeInventory();
	}
	
	protected String getTitle() {
		return title;
	}
	
	protected int getItemSlot(int slot) {
		return (page - 1) * (size - 9) + slot;
	}
	
	protected int getPrevPageSlot() {
		return size - 9;
	}
	
	protected int getBackSlot() {
		return size - 5;
	}
	
	protected int getNextPageSlot() {
		return size - 1;
	}
	
	protected int getPage() {
		return page;
	}
}