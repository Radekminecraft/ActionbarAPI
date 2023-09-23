package tech.codemein;

import net.minecraft.server.v1_14_R1.IChatBaseComponent;
import net.minecraft.server.v1_14_R1.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import tech.codemein.actionbarapi.Actionbar;

public class v_1_14_R1 implements Actionbar {
    @Override
    public void sendActionbar(Player p, String message) {
        IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");

        PacketPlayOutChat bar = new PacketPlayOutChat(icbc);

        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(bar);
    }
}
