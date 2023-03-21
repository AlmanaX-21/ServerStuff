package me.almana.serverstuff.models;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public class SuperiorItem {

    public SuperiorItem(String name, List<String> lore, ItemStack itemStack) {
        this.name = name;
        this.lore = lore;
        this.itemStack = itemStack;
    }

    private String name;
    private List<String> lore;
    private ItemStack itemStack;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLore() {
        return lore;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }
}
