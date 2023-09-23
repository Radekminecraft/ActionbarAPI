package tech.codemein.actionbarapi;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;


public final class ActionbarAPI extends JavaPlugin {
    static Actionbar ap;

    static {
        try {
            String packageName = ActionbarAPI.class.getPackage().getName();
            String internalsName = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
            ap = (Actionbar) Class.forName(packageName + "." + internalsName).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException exception) {
            Bukkit.getLogger().log(Level.SEVERE, "ItemUtil could not find a valid implementation for this server version.");
        }
    }
    public static void sendActionbar(Player player, String message) {
        ap.sendActionbar(player, message);
    }
}
