package de.Skelet.StaffChat.Main;

import de.Skelet.StaffChat.Commands.StaffChatCMD;
import de.Skelet.StaffChat.Listener.PlayerChatListener;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by skele on 15.05.2016.
 */
public class Main extends JavaPlugin{

    public static ArrayList<Player> staff = new ArrayList<>();

    private static File file = new File("plugins/StaffChat", "Config.yml");
    private static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    private static void saveFile(){
        try{
            cfg.save(file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String shortcut;
    public static String pr;
    public static String on;
    public static String off;
    public static String perm;
    public static String noperm;
    public static String noplayer;

    @Override
    public void onEnable(){
        cfg.addDefault("ShortCut", "!");
        cfg.addDefault("prefix", "&7[&cStaff&7] ");
        cfg.addDefault("staff_on", "Du schreibst nun in den &cStaffChat&c!");
        cfg.addDefault("staff_off", "Du schreibst nun nichtmehr in den &cStaffChat&c!");
        cfg.addDefault("permissions", "Staffchat.*");
        cfg.addDefault("no_permissions", "&cDu hast keine Berechtigung für diesen Command!");
        cfg.addDefault("kein_spieler", "&cDu musst ein Spieler sein um diesen Command nutzen zu können!");
        cfg.options().copyDefaults(true);
        saveFile();

        shortcut = cfg.getString("ShortCut");
        pr = cfg.getString("prefix").replace("&", "§");
        on = pr + cfg.getString("staff_on").replace("&", "§");
        off = pr + cfg.getString("staff_off").replace("&", "§");
        perm = cfg.getString("permissions");
        noperm = pr + cfg.getString("no_permissions").replace("&", "§");
        noplayer = pr + cfg.getString("kein_spieler").replace("&", "§");

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerChatListener(), this);

        getCommand("staff").setExecutor(new StaffChatCMD());
        getCommand("staffchat").setExecutor(new StaffChatCMD());
        getCommand("sc").setExecutor(new StaffChatCMD());
    }
}
