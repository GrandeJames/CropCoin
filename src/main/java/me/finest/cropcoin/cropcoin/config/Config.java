package me.finest.cropcoin.cropcoin.config;

import me.finest.cropcoin.cropcoin.CropCoin;
import me.finest.cropcoin.cropcoin.utils.Messages;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;

public class Config {

    private final CropCoin plugin;

    private File configFile;
    private FileConfiguration config;

    private Messages messages;

    public Config(CropCoin plugin) {
        this.plugin = plugin;
        this.loadConfig();
    }

    /**
     * Load the custom config.
     */
    public void loadConfig() {
        if (configFile == null) {
            configFile = new File(plugin.getDataFolder(), "config.yml");
        }
        if (!configFile.exists()) {
            plugin.saveResource("config.yml", true);
        }
        config = YamlConfiguration.loadConfiguration(configFile);

        String invalidPlayer = this.getConfig().getString("invalid-player");
        String invalidAmt = this.getConfig().getString("invalid-amount");
        String noPermission = this.getConfig().getString("no-permission");
        List<String> commandUsage = this.getConfig().getStringList("command-usage");
        String giveSender = this.getConfig().getString("give-sender");
        String giveReceiver = this.getConfig().getString("give-receiver");
        String removeSender = this.getConfig().getString("remove-sender");
        String removeReceiver = this.getConfig().getString("remove-receiver");
        String setSender = this.getConfig().getString("set-sender");
        String setReceiver = this.getConfig().getString("set-receiver");
        String balanceSender = this.getConfig().getString("balance-sender");
        String balanceReceiver = this.getConfig().getString("balance-receiver");
        String notPlayer = this.getConfig().getString("not-a-player");

        messages = new Messages(invalidPlayer, invalidAmt, noPermission, commandUsage, giveSender, giveReceiver,
                removeSender, removeReceiver, setSender, setReceiver, balanceSender, balanceReceiver, notPlayer);
    }

    /**
     * Get the custom config.
     *
     * @return The custom config.
     */
    public FileConfiguration getConfig() {
        if (config == null) {
            loadConfig();
        }
        return config;
    }

    /**
     * Get the messages.
     *
     * @return The messages.
     */
    public Messages getMessages() {
        return this.messages;
    }
}
