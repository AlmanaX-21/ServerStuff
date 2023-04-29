package me.almana.serverstuff.eventlisteners;

import io.papermc.paper.chat.ChatRenderer;
import io.papermc.paper.event.player.AsyncChatEvent;
import me.almana.serverstuff.ServerStuff;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class ChatListener implements Listener {

    MiniMessage miniMessage = ServerStuff.getMiniMessage();

    @EventHandler
    public void onChat(AsyncChatEvent e) {

        Player sender = e.getPlayer();
        e.renderer(new ChatRenderer() {
            @Override
            public @NotNull Component render(@NotNull Player source, @NotNull Component sourceDisplayName, @NotNull Component message, @NotNull Audience viewer) {

                String unserialised = "<color:#ffa19c>[PREFIX]<color:#63d6ff> ";
                return miniMessage.deserialize(unserialised).append(sourceDisplayName)
                        .append(miniMessage.deserialize(": <color:#adadad>").append(message));
            }
        });
    }
}
