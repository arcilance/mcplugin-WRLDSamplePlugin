package me.arcilance.mcplugins.wrldsampleplugin;

import com.nftworlds.wallet.objects.Network;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BuyCommand implements CommandExecutor {

    private WRLDSamplePlugin plugin;

    public BuyCommand(WRLDSamplePlugin plugin) {

        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {

            sender.sendMessage(ChatColor.RED + "This command can only be run by a player.");
            return true;
        }

        if (args.length != 1) {

            return false;
        }

        Metal metal;

        try {
            metal = Metal.valueOf(args[0].toUpperCase());
        }
        catch (IllegalArgumentException e) {

            sender.sendMessage(ChatColor.RED + "Invalid material!");
            return false;
        }

        plugin.getPaymentsAPI().getNFTPlayer(player).getPrimaryWallet().requestWRLD(metal.getSellValue(), Network.POLYGON, "Bought " + metal.getAmount() + "x " + metal.name(), false, new ItemPayload(metal));


        return true;
    }
}
