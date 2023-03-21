package me.almana.serverstuff.eventlisteners;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import me.almana.serverstuff.ServerStuff;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GearTableClickListener implements Listener {

    @EventHandler
    public void onAnvilClick(PlayerInteractEvent e) {

        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (e.getClickedBlock().getType() == Material.AIR) return;
        if (!(e.getClickedBlock().getType() == Material.ANVIL)) return;
        if (!e.getAction().isRightClick()) return;
        if (e.getHand() == EquipmentSlot.HAND) {

            e.setCancelled(true);
            craftingGui(e.getPlayer());
            // e.getPlayer().sendMessage("Crafting gui opened.");
        }
    }

    private void craftingGui(Player player) {

        Gui gui = Gui.gui()
                .title(ServerStuff.getMiniMessage().deserialize("<color:#a1a1ff><!i>Crafting Anvil"))
                .rows(6)
                .create();
        gui.disableAllInteractions();
        ItemStack frameItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta frameItemMeta = frameItem.getItemMeta();
        frameItemMeta.displayName(ServerStuff.getMiniMessage().deserialize("<gray>"));
        frameItem.setItemMeta(frameItemMeta);
        GuiItem item = ItemBuilder.from(frameItem).asGuiItem();
        gui.getFiller().fill(item);
        gui.open(player);
    }
}
