package me.almana.serverstuff.eventlisteners;

import me.almana.serverstuff.ServerStuff;
import me.almana.serverstuff.utils.BlockDropClass;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class BlockBreakListener implements Listener {

    private static HashMap<Material, ItemStack> blockDropMap = BlockDropClass.blockDropsMap;

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {

        Material block = e.getBlock().getType();
        if (!(e.getPlayer().getGameMode() == GameMode.SURVIVAL)) return;
        if (blockDropMap.containsKey(block)) {

            e.getBlock().getWorld().dropItem(e.getBlock().getLocation().add(0, 1, 0), blockDropMap.get(block));
            Bukkit.getScheduler().runTaskTimer(ServerStuff.getPlugin(), () -> {

                e.getBlock().setType(block, false);
            }, 100L, 1L);
        } else {

            e.setCancelled(true);
            e.getPlayer().sendActionBar(ServerStuff.getMiniMessage().deserialize("<red>Block cannot be broken."));
        }
    }
}
