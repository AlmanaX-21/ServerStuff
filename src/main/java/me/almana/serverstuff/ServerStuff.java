package me.almana.serverstuff;

import me.almana.serverstuff.eventlisteners.BlockBreakListener;
import me.almana.serverstuff.eventlisteners.GearTableClickListener;
import me.almana.serverstuff.utils.BlockDropClass;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerStuff extends JavaPlugin {

    private static ServerStuff plugin;
    private static final MiniMessage miniMessage = MiniMessage.miniMessage();

    @Override
    public void onEnable() {

        plugin = this;
        getConfig().options().copyDefaults();
        BlockDropClass.addingItems();
        registerEvents();
        logLoad();
    }

    @Override
    public void onDisable() {

        this.getLogger().info("Shutting down");
    }


    private void logLoad() {

        this.getLogger().info("|||||||||||||||||||||||||");
        this.getLogger().info("|||||||||||||||||||||||||");
        this.getLogger().info("Plugin Loaded Successfully.");
        this.getLogger().info("|||||||||||||||||||||||||");
        this.getLogger().info("|||||||||||||||||||||||||");
    }

    private void registerEvents() {

        this.getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        this.getServer().getPluginManager().registerEvents(new GearTableClickListener(), this);
    }

    public static ServerStuff getPlugin() {
        return plugin;
    }

    public static MiniMessage getMiniMessage() {
        return miniMessage;
    }
}
