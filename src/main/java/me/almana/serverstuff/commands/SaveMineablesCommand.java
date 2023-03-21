package me.almana.serverstuff.commands;

import me.almana.serverstuff.ServerStuff;
import me.almana.serverstuff.utils.JsonUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class SaveMineablesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        try {
            JsonUtils.saveMiningStructure();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sender.sendMessage(ServerStuff.getMiniMessage().deserialize("<green>Saved mineables.json"));

        return true;
    }
}
