package me.almana.serverstuff.eventlisteners;

import me.almana.serverstuff.utils.MobDropClass;
import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MobKillEvent implements Listener {

    @EventHandler
    public void onMobKill(EntityDeathEvent e) {

        if (e.getEntity().getKiller() != null) {
            if (e.getEntity().getKiller().getGameMode() == GameMode.SURVIVAL) return;
            EntityType mob = e.getEntityType();
            if (MobDropClass.mobDropMap.containsKey(mob)) {

                e.getEntity().getLocation().getWorld().dropItem(e.getEntity().getEyeLocation(), MobDropClass.mobDropMap.get(mob));
            }
        }
    }
}
