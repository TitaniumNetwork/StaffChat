package de.Skelet.StaffChat.Commands;

import de.Skelet.StaffChat.Main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * Created by skele on 15.05.2016.
 */
public class StaffChatCMD implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args){
        if(cs instanceof ConsoleCommandSender){
            cs.sendMessage(Main.noplayer);
            return true;
        }
        Player p = (Player) cs;
        if(p.hasPermission(Main.perm)){
            if(Main.staff.contains(p)){
                Main.staff.remove(p);
                p.sendMessage(Main.off);
            }else {
                Main.staff.add(p);
                p.sendMessage(Main.on);
            }
        }else{
            p.sendMessage(Main.noperm);
        }
        return false;
    }
}
