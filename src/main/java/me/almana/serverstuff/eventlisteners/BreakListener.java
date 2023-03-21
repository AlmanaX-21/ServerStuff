package me.almana.serverstuff.eventlisteners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakListener implements Listener {

    /*
    The Plan:
        1. Block mine = check if block is in map
        2. Get info of what item to drop from map
        3. Set block back to air
    */

    @EventHandler(priority = EventPriority.HIGH)
    public void onBreak(BlockBreakEvent e) {

        Block block = e.getBlock();
        Material blockType = block.getType();


    }

}
