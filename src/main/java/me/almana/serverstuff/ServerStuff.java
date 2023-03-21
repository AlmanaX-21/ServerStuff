package me.almana.serverstuff;

import me.almana.serverstuff.commands.SaveMineablesCommand;
import me.almana.serverstuff.utils.JsonUtils;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class ServerStuff extends JavaPlugin {

    private static ServerStuff plugin;
    private static MiniMessage miniMessage = MiniMessage.miniMessage();

    @Override
    public void onEnable() {

        plugin = this;
        getConfig().options().copyDefaults();
        this.getCommand("savemineables").setExecutor(new SaveMineablesCommand());

        try {
            checkJsonFile(JsonUtils.getFile());
            JsonUtils.loadMiningStructure();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logLoad();
    }

    @Override
    public void onDisable() {

        try {
            JsonUtils.saveMiningStructure();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void logLoad() {

        this.getLogger().info("|||||||||||||||||||||||||");
        this.getLogger().info("|||||||||||||||||||||||||");
        this.getLogger().info("Plugin Loaded Successfully.");
        this.getLogger().info("|||||||||||||||||||||||||");
        this.getLogger().info("|||||||||||||||||||||||||");
    }

    public void checkJsonFile(File file) throws IOException {

        if (!file.exists()) {

            file.getParentFile().mkdirs();
            file.createNewFile();
            this.getLogger().info("Created " + file.getName());
        }
    }

    public static ServerStuff getPlugin() {
        return plugin;
    }

    public static MiniMessage getMiniMessage() {
        return miniMessage;
    }
}
