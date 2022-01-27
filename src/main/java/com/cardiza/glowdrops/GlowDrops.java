package com.cardiza.glowdrops;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class GlowDrops extends JavaPlugin implements Listener {

    int source = 0;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, (Plugin)this);
        Logger logger = getLogger();
        (new UpdateChecker((Plugin)this, 78348)).getVersion(version -> {
            if (getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info(ChatColor.GREEN + "There is not a new update available.");
            } else {
                logger.info(ChatColor.DARK_RED + "There is a new update available.");
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void playerDropItem(PlayerDropItemEvent e) {
        BetterItem item = new BetterItem(e.getItemDrop(),1);
    }

    @EventHandler
    public void entityDeathDropItem(EntityDeathEvent e) {
        BetterItem item = new BetterItem((Entity) e.getEntity(),2);
    }

    @EventHandler
    public void entityDropItem(EntityDropItemEvent e){
        BetterItem item = new BetterItem(e.getEntity(),3);
    }

    @EventHandler
    public void blockDropItem(BlockDropItemEvent e){
        for (Item drop : e.getItems())
        {
            BetterItem item = new BetterItem(drop,4);
        }
    }
}
