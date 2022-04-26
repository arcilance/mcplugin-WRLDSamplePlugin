package me.arcilance.mcplugins.wrldsampleplugin;

import com.nftworlds.wallet.event.PlayerTransactEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerTransactEventListener implements Listener {

    @EventHandler
    public void onPlayerTransact(PlayerTransactEvent<?> e) {
        if (e.getPayload() instanceof ItemPayload payload) {
            e.getPlayer().sendMessage("Thank you for your purchase!");
            e.getPlayer().getInventory().addItem(payload.metal);
        }
    }
}
