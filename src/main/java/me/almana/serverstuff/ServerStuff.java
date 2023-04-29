package me.almana.serverstuff;

import me.almana.serverstuff.commands.DiscordCmd;
import me.almana.serverstuff.commands.GearCraftTestCmd;
import me.almana.serverstuff.commands.TagCommand;
import me.almana.serverstuff.eventlisteners.BlockBreakListener;
import me.almana.serverstuff.eventlisteners.ChatListener;
import me.almana.serverstuff.eventlisteners.GearTableClickListener;
import me.almana.serverstuff.eventlisteners.JoinListenerTemp;
import me.almana.serverstuff.utils.BlockDropClass;
import me.almana.serverstuff.utils.PrefixUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerStuff extends JavaPlugin {

    private static ServerStuff plugin;
    private static final MiniMessage miniMessage = MiniMessage.miniMessage();
    public static final Component SERVER_PREFIX = miniMessage.deserialize("<color:#ff594a>[SuperiorMine]</color> ");
    private LuckPerms luckPerms;

    // Error Colour: <color:#ff371c>
    // <color:#ffa19c>[PREFIX] <color:#63d6ff>AlmanaX21: <color:#adadad>General people chat

    @Override
    public void onEnable() {

        plugin = this;
        getConfig().options().copyDefaults();
        BlockDropClass.addingItems();
        registerEvents();
        registerCommands();
        luckPerms = getLuckAPI();
        PrefixUtils.prefixSetup();
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
        this.getServer().getPluginManager().registerEvents(new JoinListenerTemp(), this);
        this.getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }

    private void registerCommands() {

        this.getServer().getPluginCommand("testgearcraft").setExecutor(new GearCraftTestCmd());
        this.getServer().getPluginCommand("discord").setExecutor(new DiscordCmd());
        this.getServer().getPluginCommand("tags").setExecutor(new TagCommand(luckPerms));
    }

    private LuckPerms getLuckAPI() {

        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider == null) {

            this.getLogger().severe("Provider is null..");
            return null;
        }
        return provider.getProvider();
    }

    public static ServerStuff getPlugin() {
        return plugin;
    }

    public static MiniMessage getMiniMessage() {
        return miniMessage;
    }
}
