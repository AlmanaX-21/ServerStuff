package me.almana.serverstuff.eventlisteners;

import me.almana.serverstuff.ServerStuff;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListenerTemp implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Bukkit.getServer().getScheduler().runTaskLater(ServerStuff.getPlugin(), () -> {

            e.getPlayer().sendMessage(ServerStuff.getMiniMessage().deserialize("<color:#ff322b>[SuperiorMine]: <color:#5c9dff>Welcome to the server! We are <color:#6bff66><u>under development</u><color:#5c9dff>, you can join the discord if you wish to. <dark_red>There is no ETA for server release.<color:#5c9dff>Join discord here at <green><click:open_url:'https://discord.gg/Rx7EZRxQGt'>discord.gg/SuperiorMine.</click>"));
        }, 10L);
    }
}
