package me.arcilance.mcplugins.wrldsampleplugin;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

enum Metal {
    GOLD(16, Material.GOLD_INGOT, 2.5, 5),
    DIAMOND(1, Material.DIAMOND, 5, 10);

    private final int amount;
    private final Material material;
    private double sellValue;
    private double buyValue;

    Metal (int amount, Material material, double buyValue, double sellValue) {

        this.amount = amount;
        this.material = material;
        this.buyValue = buyValue;
        this.sellValue = sellValue;
    }

    public ItemStack getItem() {
        return new ItemStack(material, amount);
    }

    public double getSellValue() {
        return sellValue;
    }

    public double getBuyValue() {
        return buyValue;
    }

    public int getAmount() {
        return amount;
    }

    public Material getMaterial() {
        return material;
    }
}
