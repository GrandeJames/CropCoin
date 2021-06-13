package me.finest.cropcoin.cropcoin;

import me.finest.cropcoin.cropcoin.commands.CropCoinCommand;
import me.finest.cropcoin.cropcoin.config.Config;
import me.finest.cropcoin.cropcoin.config.Data;
import me.finest.cropcoin.cropcoin.listeners.BlockBreakListener;
import me.finest.cropcoin.cropcoin.utils.SomeExpansion;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CropCoin extends JavaPlugin {

    private Config config;
    private Data data;

    @Override
    public void onEnable() {
        // Small check to make sure that PlaceholderAPI is installed
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new SomeExpansion(this).register();

            getCommand("cropcoin").setExecutor(new CropCoinCommand(this));
            getServer().getPluginManager().registerEvents(new BlockBreakListener(this), this);

            config = new Config(this);
            data = new Data(this);
        } else {
            getLogger().warning("Could not find PlaceHolderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        if (this.data.getBalances() != null) {
            for (Balance balance : this.data.getBalances()) {
                this.getData().getConfig().set("Players." + balance.getUUID(), balance.getBalance());
            }
            getData().saveData();
        }
    }

    /**
     * Get the config.
     *
     * @return The config.
     */
    public Config getCustomConfig() {
        return config;
    }

    /**
     * Get the data.
     *
     * @return The data.
     */
    public Data getData() {
        return data;
    }
}
