package com.cardiza.glowdrops;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.plugin.Plugin;
import org.inventivetalent.glow.GlowAPI;

import java.util.ArrayList;
import java.util.List;

public class BetterItem {
    private Item item;
    private int source;
    private String color;

    public BetterItem(Item item, int source){
        this.item = item;
        this.source = source;

        Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) this, new Runnable() {
            @Override
            public void run() {
                GlowAPI.setGlowing((Entity)item, GlowAPI.Color.valueOf(getColorFromSource(source)), Bukkit.getOnlinePlayers());
            }
        },1L,1L);
    }

    public BetterItem(Entity entity, int source){
        this.source = source;

        Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) this, new Runnable() {
            @Override
            public void run() {
                GlowAPI.setGlowing(entity, GlowAPI.Color.valueOf(getColorFromSource(source)), Bukkit.getOnlinePlayers());
            }
        },1L,1L);
    }

    public String getColorFromSource(int source){
        List<String> colors = new ArrayList<String>(); 
        colors.add("RED");
        colors.add("DARK_RED");
        colors.add("GREEN");
        colors.add("DARK_GREEN");
        colors.add("AQUA");
        colors.add("BLUE");
        colors.add("DARK_BLUE");
        colors.add("YELLOW");
        colors.add("GOLD");
        colors.add("DARK_PURPLE");
        colors.add("WHITE");
        colors.add("GRAY");
        colors.add("DARK_GRAY");
        colors.add("BLACK");
        return colors.get(source);
    }
}
