package me.almana.serverstuff.commands;

import me.almana.serverstuff.ServerStuff;
import me.almana.serverstuff.utils.CraftingUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GearCraftTestCmd implements TabExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player player) {

            player.sendMessage(ServerStuff.SERVER_PREFIX.append(ServerStuff.getMiniMessage().deserialize("<green> Crafted Item.")));
            player.getInventory().addItem(CraftingUtils.craftGear(player, Material.matchMaterial(args[0]), Integer.parseInt(args[1]), "GEAR"));
        }
        return true;
    }


    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length == 1) {
            return Arrays.stream(Material.values())
                    .map(Material::name)
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
