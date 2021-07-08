package me.anuzsubedi.sleepmessages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import java.util.Random;

public class Messages implements Listener {
    private int numberOfMessages;
    private Main main;
    private FileConfiguration config;
    public Messages(Main main){
        this.main=main;
        this.numberOfMessages= main.getConfig().getKeys(true).size();
        this.config = main.getConfig();
    }


    Random random = new Random();


    @EventHandler
    public void OnSleep(PlayerBedLeaveEvent e){
        int messageNumber =random.ints(1,numberOfMessages+1).findFirst().getAsInt();
        String message =config.getString(String.valueOf(messageNumber));
        Bukkit.broadcastMessage(ChatColor.GREEN+message);
    }
}
