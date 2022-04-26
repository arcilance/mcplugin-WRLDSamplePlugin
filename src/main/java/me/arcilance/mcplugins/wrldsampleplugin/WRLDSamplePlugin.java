package me.arcilance.mcplugins.wrldsampleplugin;

import com.nftworlds.wallet.api.WalletAPI;
import com.nftworlds.wallet.objects.Network;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class WRLDSamplePlugin extends JavaPlugin {

    private WalletAPI walletAPI;

    @Override
    public void onEnable() {
        // Plugin startup logic

        walletAPI = new WalletAPI();

        this.getCommand("sell").setExecutor(new SellCommand(this));
        this.getCommand("buy").setExecutor(new BuyCommand(this));

        this.getServer().getPluginManager().registerEvents(new PlayerTransactEventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public WalletAPI getPaymentsAPI() {

        return walletAPI;
    }
}
