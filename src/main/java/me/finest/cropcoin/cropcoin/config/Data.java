/**
 * The data file contains the players' UUID's and balance.
 */
package me.finest.cropcoin.cropcoin.config;

import me.finest.cropcoin.cropcoin.Balance;
import me.finest.cropcoin.cropcoin.CropCoin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private File dataFile;
    private FileConfiguration data;

    // List of all the balances.
    private List<Balance> balances = new ArrayList<Balance>();

    private final CropCoin plugin;

    /**
     * Constructor
     */
    public Data(CropCoin plugin) {
        this.plugin = plugin;
        this.loadData();
    }

    /**
     * Load the custom config.
     */
    public void loadData() {
        if (dataFile == null) {
            dataFile = new File(plugin.getDataFolder(), "data.yml");
        }
        if (!dataFile.exists()) {
            plugin.saveResource("data.yml", true);
        }
        data = YamlConfiguration.loadConfiguration(dataFile);

        addBalancesFromDataFile();
    }

    /**
     * Get the custom config.
     *
     * @return The custom config.
     */
    public FileConfiguration getConfig() {
        if (data == null) {
            loadData();
        }
        return data;
    }

    /**
     * Save the data file.
     */
    public void saveData() {
        try {
            this.getConfig().save(this.dataFile);
        } catch(IOException exception) {
            System.out.println("Error: could not save data config file");
        }
    }

    /**
     * Get all the balances.
     *
     * @return All the balances.
     */
    public List<Balance> getBalances() {
        return this.balances;
    }

    /**
     * Check if the player has a balance.
     *
     * @param uuid The player's uuid.
     */
    public boolean containsBalance(String uuid) {
        if (this.balances != null) {
            for (Balance balance : this.balances) {
                if (balance.getUUID().equals(uuid)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Get the player's balance.
     *
     * @param uuid The player's uuid.
     * @return The player's balance.
     */
    public Balance getBalance(String uuid) {
        // Get player's balance if already there.
        if (containsBalance(uuid)) {
            for (Balance balance : this.getBalances()) {
                if (balance.getUUID().equals(uuid)) {
                    return balance;
                }
            }
        }
        // Give a new balance.
        Balance balance = new Balance(0, uuid, plugin);
        this.addBalance(balance);

        return balance;
    }

    /**
     * Add all the balances from the data file.
     */
    public void addBalancesFromDataFile() {
        // Set the balances of each player already in the config.
        if (this.getConfig().getConfigurationSection("Players") != null) {
            for (String uuid : this.getConfig().getConfigurationSection("Players").getKeys(false)) {
                int amtInBalance = this.getConfig().getInt("Players." + uuid);
                this.addBalance(new Balance(amtInBalance, uuid, plugin));
            }
        }
    }

    /**
     * Add balance to the balances.
     *
     * @param balance The balance to add.
     */
    public void addBalance(Balance balance) {
        if (balances == null) {
            this.balances = new ArrayList<Balance>();
        }
        this.balances.add(balance);
    }
}