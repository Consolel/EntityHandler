package com.console.listeners;

import org.bukkit.entity.Slime;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import com.console.files.CustomConfig;
import org.bukkit.event.entity.EntitySpawnEvent;

public final class SpawnListener implements Listener {
    
    @EventHandler
    void EntitySpawnEvent(EntitySpawnEvent evt) {
        final int percentage = CustomConfig.get().getInt("Reduction");
        final boolean hasPercent = percentage > (1 + (int) (Math.random() * 100));
        
        if(evt.getEntity() instanceof Slime && hasPercent)  {
            evt.getEntity().remove();
        }
    }
}
