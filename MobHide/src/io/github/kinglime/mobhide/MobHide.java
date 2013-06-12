package io.github.kinglime.mobhide;
 
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.plugin.java.JavaPlugin;
 
public final class MobHide extends JavaPlugin implements Listener {
   
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Created listener");
    }
   
    public void onDisable() {
    }
   
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityTarget(EntityTargetEvent event) {
        getLogger().info("Listening...");
        if (event.getTarget().getType() == EntityType.PLAYER) {
            getLogger().info("A Player has been targeted.");
            Player player = (Player) event.getTarget();
            if ((player.hasPermission("mobhide.hidden")) && (!event.isCancelled())) {
                getLogger().info("Player has sufficient permissions.");
                EntityType type = event.getEntity().getType();
                if (type == EntityType.ENDERMAN || type == EntityType.WOLF || type == EntityType.PIG_ZOMBIE || type == EntityType.BLAZE || type == EntityType.CAVE_SPIDER || type == EntityType.CREEPER || type == EntityType.GHAST || type == EntityType.MAGMA_CUBE || type == EntityType.SILVERFISH || type == EntityType.SKELETON || type == EntityType.SLIME || type == EntityType.SPIDER || type == EntityType.WITCH || type == EntityType.WITHER_SKULL || type == EntityType.ZOMBIE || type == EntityType.IRON_GOLEM || type == EntityType.ENDER_DRAGON || type == EntityType.WITHER) {
                    getLogger().info("Cancelling event.");
                    event.setCancelled(true);
                }
            }
        }
    }
}