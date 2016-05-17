package de.Skelet.StaffChat.Listener;

import de.Skelet.StaffChat.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by skele on 15.05.2016.
 */
public class PlayerChatListener implements Listener{

    @EventHandler
    public void on(AsyncPlayerChatEvent e){
        if(e.getMessage().startsWith(Main.shortcut)){
            for(Player p : Bukkit.getOnlinePlayers()){
                if(!p.hasPermission(Main.perm))continue;
                p.sendMessage(Main.pr + e.getPlayer().getDisplayName() + " §7» §r" + e.getMessage().replace(e.getMessage().charAt(0) + "", ""));
                e.setCancelled(true);
            }
        }
        if(Main.staff.contains(e.getPlayer())){
            for(Player p : Bukkit.getOnlinePlayers()){
                if(!p.hasPermission(Main.perm))continue;
                p.sendMessage(Main.pr + e.getPlayer().getDisplayName() + " §7» §r" + e.getMessage());
                e.setCancelled(true);
            }
        }
    }
}
