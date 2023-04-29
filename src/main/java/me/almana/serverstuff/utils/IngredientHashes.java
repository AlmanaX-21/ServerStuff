package me.almana.serverstuff.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class IngredientHashes {

    public static HashMap<Material, Integer> LEVEL_1 = new HashMap<Material, Integer>(Map.of(Material.IRON_INGOT, 20,
            Material.OAK_LOG, 30, Material.LEATHER, 15));
    // 0-10
    public static HashMap<Material, Integer> LEVEL_2 = new HashMap<Material, Integer>(Map.of(Material.IRON_INGOT, 30,
            Material.OAK_LOG, 50, Material.LEATHER, 40, Material.GOLD_INGOT, 30));
    // 10-20
    public static HashMap<Material, Integer> LEVEL_3 = new HashMap<Material, Integer>(Map.of(Material.IRON_INGOT, 50,
            Material.SPRUCE_LOG, 90, Material.LEATHER, 65, Material.GOLD_INGOT, 60));
    // 20-30
    public static HashMap<Material, Integer> LEVEL_4 = new HashMap<Material, Integer>(Map.of(Material.IRON_INGOT, 65,
            Material.SPRUCE_LOG, 160, Material.LEATHER, 105, Material.GOLD_INGOT, 90, Material.DIAMOND, 30));
    // 30-40
    public static HashMap<Material, Integer> LEVEL_5 = new HashMap<Material, Integer>(Map.of(Material.IRON_BLOCK, 20,
            Material.DARK_OAK_LOG, 190, Material.LEATHER, 125, Material.GOLD_INGOT, 110, Material.DIAMOND, 50));
    // 40-60
    public static HashMap<Material, Integer> LEVEL_6 = new HashMap<Material, Integer>(Map.of(Material.IRON_BLOCK, 50,
            Material.DARK_OAK_LOG, 250, Material.LEATHER, 150, Material.GOLD_INGOT, 130, Material.DIAMOND, 80));
    // 60-80
    public static HashMap<Material, Integer> LEVEL_7 = new HashMap<Material, Integer>(Map.of(Material.IRON_BLOCK, 100,
            Material.DARK_OAK_LOG, 300, Material.LEATHER, 200, Material.GOLD_INGOT, 150, Material.DIAMOND, 120));
    // 80-100

    public static HashMap<Material, Integer> returnIngredients(float xp) {

        if (xp <= 10) {
            return LEVEL_1;
        } else if (xp <= 20) {
            return LEVEL_2;
        } else if (xp <= 30) {
            return LEVEL_3;
        } else if (xp <= 40) {
            return LEVEL_4;
        } else if (xp <= 60) {
            return LEVEL_5;
        } else if (xp <= 80) {
            return LEVEL_6;
        } return LEVEL_7;
    }
}
