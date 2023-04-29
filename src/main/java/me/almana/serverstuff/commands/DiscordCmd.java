package me.almana.serverstuff.commands;

import me.almana.serverstuff.ServerStuff;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DiscordCmd implements CommandExecutor {

    private final MiniMessage miniMessage = ServerStuff.getMiniMessage();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player player) {
            if (args.length == 0) {

                player.sendMessage(ServerStuff.SERVER_PREFIX.
                        append(miniMessage.deserialize("<color:#409fff>Join our discord at <color:#6bffda><u><click:open_url:'https://discord.gg/Rx7EZRxQGt'></click><hover:show_text:'<color:#bfff66>Come on, join it!!'>discord.gg/SuperiorMine")));
            } else {

                Player target = ServerStuff.getPlugin().getServer().getPlayer(args[0]);
                if (target == null) {
                    if (args[0].equalsIgnoreCase("broadcast")) {

                        player.getServer().getOnlinePlayers().forEach(audience -> audience.sendMessage(ServerStuff.SERVER_PREFIX.
                                append(miniMessage.deserialize("<color:#409fff>Join our discord at <color:#6bffda><u><click:open_url:'https://discord.gg/Rx7EZRxQGt'></click><hover:show_text:'<color:#bfff66>Come on, join it!!'>discord.gg/SuperiorMine"))));
                    }

                    player.sendMessage(ServerStuff.SERVER_PREFIX.append(miniMessage.deserialize("<color:#ff371c>No such player found.")));
                } else {

                    target.sendMessage(ServerStuff.SERVER_PREFIX.
                            append(miniMessage.deserialize("<color:#409fff>Join our discord at <color:#6bffda><u><click:open_url:'https://discord.gg/Rx7EZRxQGt'></click><hover:show_text:'<color:#bfff66>Come on, join it!!'>discord.gg/SuperiorMine")));
                }
            }
        }
        return true;
    }
}
