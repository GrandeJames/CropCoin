package me.finest.cropcoin.cropcoin.listeners;

import me.finest.cropcoin.cropcoin.Balance;
import me.finest.cropcoin.cropcoin.CropCoin;
import me.finest.cropcoin.cropcoin.config.Data;
import org.bukkit.Material;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    private final CropCoin plugin;

    public BlockBreakListener(CropCoin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (!(event.getBlock().getBlockData() instanceof Ageable)) {
            return;
        }
        Ageable ageable = (Ageable) event.getBlock().getBlockData();
        if (ageable.getAge() < ageable.getMaximumAge()) {
            return;
        }
        Material material = event.getBlock().getType();
        if (material != Material.BEETROOTS && material != Material.CARROTS
                && material != Material.POTATOES && material != Material.SWEET_BERRY_BUSH
                && material != Material.WHEAT) {
            return;
        }
        Data data = plugin.getData();
        Player player = event.getPlayer();
        String uuid = player.getUniqueId().toString();
        Balance balance = data.getBalance(uuid);

        final int AMT_CROPCOIN_TO_GIVE = 1;
        balance.give(AMT_CROPCOIN_TO_GIVE);

    }
}
