package me.almana.serverstuff.utils;

import me.almana.serverstuff.ServerStuff;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;

public class MobDropClass {

    public static HashMap<EntityType, ItemStack> mobDropMap = new HashMap<EntityType, ItemStack>();
    private static MiniMessage miniMessage = ServerStuff.getMiniMessage();

    private static void addItem(EntityType mob, Material drop, String name, int customDataModel, List<Component> lore) {

        ItemStack stack = new ItemStack(drop);
        ItemMeta meta = stack.getItemMeta();
        meta.displayName(miniMessage.deserialize(name));
        meta.lore(lore);
        meta.setCustomModelData(customDataModel);
        stack.setItemMeta(meta);

        mobDropMap.put(mob, stack);
    }

    public static void addingMobDrops() {

        addItem(EntityType.ZOMBIE, Material.ROTTEN_FLESH, "", 0,
                List.of(miniMessage.deserialize("<gray><!i>Common item not used for much")));
    }
}
