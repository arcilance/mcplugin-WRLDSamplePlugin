package me.arcilance.mcplugins.wrldsampleplugin;

import org.bukkit.inventory.ItemStack;

public class ItemPayload {
    public ItemStack metal;
    public ItemPayload(Metal metal) {
        this.metal = metal.getItem();
    }
}
