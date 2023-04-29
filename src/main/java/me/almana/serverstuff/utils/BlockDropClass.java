package me.almana.serverstuff.utils;

import me.almana.serverstuff.ServerStuff;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;

public class BlockDropClass {

    public static HashMap<Material, ItemStack> blockDropsMap = new HashMap<>();
    private static MiniMessage miniMessage = ServerStuff.getMiniMessage();


    private static void addItem(Material block, Material drop, Component name, int customDataModel, List<Component> lore) {

        ItemStack stack = new ItemStack(drop);
        ItemMeta meta = stack.getItemMeta();
        meta.displayName(name);
        meta.lore(lore);
        meta.setCustomModelData(customDataModel);
        stack.setItemMeta(meta);

        blockDropsMap.put(block, stack);
    }

    public static void addingItems() {

        addItem(Material.DIRT, Material.DIRT, miniMessage.deserialize("<color:#9e490d><!i>Dirt"), 0,
                List.of(miniMessage.deserialize("<gray><!i>Common item not used for much")));
        addItem(Material.COBBLESTONE, Material.GRAY_DYE, miniMessage.deserialize("<gray><!i>Pebble"), 0,
                List.of(miniMessage.deserialize("<gray><!i>Common item not used for much")));
        addItem(Material.OAK_LOG, Material.OAK_LOG, miniMessage.deserialize("<color:#9e490d><!i>Wood"), 0,
                List.of(miniMessage.deserialize("<gray><!i>Common item used a lot")));
        addItem(Material.OAK_LEAVES, Material.OAK_LEAVES, miniMessage.deserialize("<color:#24bf3e><!i>Leaves"), 0,
                List.of(miniMessage.deserialize("<gray><!i>Common item not used for much")));

        ServerStuff.getPlugin().getLogger().info("Loaded Mineable Blocks..");
    }
}
