package tech.codemein.actionbarapi;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class ActionbarAPI extends JavaPlugin {
    private static Actionbar ap;

    static {
        try {
            String packageName = ActionbarAPI.class.getPackage().getName();
            String internalsName = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
            Class<?> actionbarClass = Class.forName(packageName + "." + internalsName);
            if (Actionbar.class.isAssignableFrom(actionbarClass)) {
                ap = (Actionbar) actionbarClass.newInstance();
            } else {
                Bukkit.getLogger().log(Level.SEVERE, "Invalid Actionbar implementation for this server version.");
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException exception) {
            Bukkit.getLogger().log(Level.SEVERE, "Failed to initialize Actionbar implementation for this server version.", exception);
        }
    }

    public static void sendActionbar(Player player, String message) {
        if (ap != null) {
            ap.sendActionbar(player, message);
        } else {
            // Handle the case where ap is null (no valid implementation found)
            player.sendMessage("Actionbar not supported on this server version.");
        }
    }
}
