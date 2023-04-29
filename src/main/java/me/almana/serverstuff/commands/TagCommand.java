package me.almana.serverstuff.commands;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import me.almana.serverstuff.ServerStuff;
import me.almana.serverstuff.utils.PrefixUtils;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.PrefixNode;
import net.luckperms.api.query.QueryOptions;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TagCommand implements CommandExecutor {

    LuckPerms lp;
    private final MiniMessage miniMessage = ServerStuff.getMiniMessage();

    public TagCommand(LuckPerms lp) {
        this.lp = lp;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player player) {

            if (args.length == 0) {

                guiWorking(player);
            } else if (sender.hasPermission("core.tagmodify.others")) {

                if (Bukkit.getServer().getPlayer(args[0]) != null) {

                    Player target = Bukkit.getPlayer(args[0]);
                    guiWorking(target);
                } else {

                    player.sendMessage(ServerStuff.SERVER_PREFIX.append(miniMessage.deserialize("<color:#ff371c>Player not found.")));
                }
            }
        }
        return true;
    }

    private void guiWorking(Player player) {

        Gui gui = Gui.gui().title(miniMessage.deserialize("Select Tag"))
                .rows(4).disableAllInteractions().create();

        ItemStack fillerItem = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        fillerItem.editMeta(meta -> {

           meta.displayName(miniMessage.deserialize(" "));
        });
        GuiItem filler = ItemBuilder.from(fillerItem).asGuiItem();

        List<GuiItem> itemList = new ArrayList<>();
        HashMap<String, String> map = PrefixUtils.prefixes;

        for (int i = 0; i < map.size(); i++) {

            String prefix = (String) Arrays.stream(map.values().toArray()).toList().get(i);
            ItemStack item = new ItemStack(Material.NAME_TAG);
            ItemMeta meta = item.getItemMeta();
            meta.displayName(miniMessage.deserialize(prefix));
            item.setItemMeta(meta);
            itemList.add(ItemBuilder.from(item).asGuiItem(event -> {

                Player viewer = (Player) event.getViewers().get(0);
                lp.getUserManager().modifyUser(viewer.getUniqueId(), (User user) -> {

                    viewer.sendMessage("THIS IS THE SERIALISED: " + miniMessage.serialize(item.getItemMeta().displayName()));
                    user.data().clear(NodeType.PREFIX::matches);
                    Map<Integer, String> inheritedPrefixes = user.getCachedData().getMetaData(QueryOptions.nonContextual()).getPrefixes();
                    int priority = inheritedPrefixes.keySet().stream().mapToInt(j -> j + 10).max().orElse(10);
                    Node node = PrefixNode.builder(miniMessage.serialize(item.getItemMeta().displayName()), priority).build();
                    user.data().add(node);
                });
            }));
        }

        gui.getFiller().fill(filler);
        for (GuiItem item: itemList) {

            gui.setItem(9 + itemList.indexOf(item), item);
        }

        gui.open(player);
    }
}