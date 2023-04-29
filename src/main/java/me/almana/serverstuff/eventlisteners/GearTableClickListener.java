package me.almana.serverstuff.eventlisteners;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import me.almana.serverstuff.ServerStuff;
import me.almana.serverstuff.utils.CraftingUtils;
import net.kyori.adventure.text.minimessage.MiniMessage;
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

    private final MiniMessage mm = ServerStuff.getMiniMessage();

    @EventHandler
    public void onAnvilClick(PlayerInteractEvent e) {

        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (e.getClickedBlock().getType() == Material.AIR) return;
        if (!(e.getClickedBlock().getType() == Material.ANVIL)) return;
        if (!e.getAction().isRightClick()) return;
        if (e.getHand() == EquipmentSlot.HAND) {

            e.setCancelled(true);
            craftingGui(e.getPlayer());
        }
    }

    private void craftingGui(Player player) {

        Gui gui = Gui.gui()
                .title(ServerStuff.getMiniMessage().deserialize("<color:#a1a1ff><!i>Crafting Anvil"))
                .rows(5)
                .create();
        gui.disableAllInteractions();
        ItemStack frameItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta frameItemMeta = frameItem.getItemMeta();
        frameItemMeta.displayName(mm.deserialize("<gray>"));
        frameItem.setItemMeta(frameItemMeta);
        GuiItem item = ItemBuilder.from(frameItem).asGuiItem();

        ItemStack craftChestplate = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta chestplateMeta = craftChestplate.getItemMeta();
        chestplateMeta.displayName(mm.deserialize("<color:#7f78ff><!i>Craft Chestplate"));
        craftChestplate.setItemMeta(chestplateMeta);
        GuiItem chestplate = ItemBuilder.from(craftChestplate).asGuiItem(event -> {

                CraftingUtils.craftingArmorClick(player, "Chestplate");
        });

        ItemStack crafthelmet = new ItemStack(Material.IRON_HELMET);
        ItemMeta helmetMeta = crafthelmet.getItemMeta();
        helmetMeta.displayName(mm.deserialize("<color:#7f78ff><!i>Craft Helmet"));
        crafthelmet.setItemMeta(helmetMeta);
        GuiItem helmet = ItemBuilder.from(crafthelmet).asGuiItem(event -> {

            CraftingUtils.craftingArmorClick(player, "Helmet");
        });

        ItemStack craftLeggings = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta legtMeta = craftLeggings.getItemMeta();
        legtMeta.displayName(mm.deserialize("<color:#7f78ff><!i>Craft Leggings"));
        craftLeggings.setItemMeta(legtMeta);
        GuiItem leg = ItemBuilder.from(craftLeggings).asGuiItem(event -> {

            CraftingUtils.craftingArmorClick(player, "Leggings");
        });

        ItemStack craftBoots = new ItemStack(Material.IRON_BOOTS);
        ItemMeta bootMeta = craftBoots.getItemMeta();
        bootMeta.displayName(mm.deserialize("<color:#7f78ff><!i><bold>Craft Boots"));
        craftBoots.setItemMeta(bootMeta);
        GuiItem boot = ItemBuilder.from(craftBoots).asGuiItem(event -> {

            CraftingUtils.craftingArmorClick(player, "Boots");
        });

        ItemStack craftSword = new ItemStack(Material.IRON_SWORD);
        ItemMeta swordMeta = craftSword.getItemMeta();
        bootMeta.displayName(mm.deserialize("<color:#7f78ff><!i><bold>Craft Swords"));
        craftBoots.setItemMeta(swordMeta);
        GuiItem sword = ItemBuilder.from(craftSword).asGuiItem(event -> {

            CraftingUtils.craftingSwordClick(player, "Sword");
        });

        gui.getFiller().fill(item);
        gui.setItem(2, 3, chestplate);
        gui.setItem(4, 3, helmet);
        gui.setItem(2, 7, leg);
        gui.setItem(4, 7, boot);
        gui.setItem(3, 5, sword);

        gui.open(player);
    }
}
