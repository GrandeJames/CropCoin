/**
 * This will set the commands.
 * The commands:
 * Usage: /cropcoin <give/remove/set> (playerName) (amount)
 *        / cropcoin <bal/balance> (playerName)
 */
package me.finest.cropcoin.cropcoin.commands;

import me.finest.cropcoin.cropcoin.Balance;
import me.finest.cropcoin.cropcoin.CropCoin;
import me.finest.cropcoin.cropcoin.config.Data;
import me.finest.cropcoin.cropcoin.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CropCoinCommand implements CommandExecutor {

    private final CropCoin plugin;

    public CropCoinCommand(CropCoin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Messages messages = plugin.getCustomConfig().getMessages();

        switch (args.length) {
            case 1:
                if (args[0].equalsIgnoreCase("bal") || args[0].equalsIgnoreCase("balance")) {
                    if (!sender.hasPermission("cropcoin.balance")) {
                        sender.sendMessage(messages.getNoPermissionMsg());
                        return false;
                    }
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(messages.getNotPlayerMsg());
                        return false;
                    }
                    String uuid = Bukkit.getPlayer(sender.getName()).getUniqueId().toString();
                    sender.sendMessage(messages.getBalanceSenderMsg(plugin.getData().getBalance(uuid).getBalance()));
                    return true;
                }
                break;
            case 2:
                if (args[0].equalsIgnoreCase("bal") || args[0].equalsIgnoreCase("balance")) {
                    if (!sender.hasPermission("cropcoin.balance.other")) {
                        sender.sendMessage(messages.getNoPermissionMsg());
                        return false;
                    }
                    if (Bukkit.getPlayer(args[1]) == null) {
                        sender.sendMessage(messages.getInvalidPlayerMsg());
                        return false;
                    }
                    Player player = Bukkit.getPlayer(args[1]);
                    String uuid = player.getUniqueId().toString();
                    sender.sendMessage(messages.getBalanceReceiverMsg(plugin.getData().getBalance(uuid).getBalance(), player.getName()));
                    return true;
                }
                break;
            case 3:
                // Needs to have the correct amount of arguments.
                if (args.length == 3) {
                    if (Bukkit.getPlayer(args[1]) == null) {
                        sender.sendMessage(messages.getInvalidPlayerMsg());
                        return false;
                    }

                    Player player = Bukkit.getPlayer(args[1]);
                    int amount;

                    try {
                        amount = Integer.parseInt(args[2]);
                    } catch (NumberFormatException exception) {
                        sender.sendMessage(messages.getInvalidAmtMsg());
                        return false;
                    }

                    Data data = plugin.getData();
                    String uuid = player.getUniqueId().toString();
                    Balance balance = data.getBalance(uuid);

                    switch (args[0].toLowerCase()) {
                        case "give":
                            if (!sender.hasPermission("cropcoin.give")) {
                                sender.sendMessage(messages.getNoPermissionMsg());
                                return false;
                            }
                            balance.give(amount);
                            sender.sendMessage(messages.getGiveSenderMsg(player.getName(), balance.getBalance(), amount));
                            player.sendMessage(messages.getGiveReceiverMsg(player.getName(), balance.getBalance(), amount));
                            return true;
                        case "remove":
                            if (!sender.hasPermission("cropcoin.remove")) {
                                sender.sendMessage(messages.getNoPermissionMsg());
                                return false;
                            }
                            balance.remove(amount);
                            sender.sendMessage(messages.getRemoveSenderMsg(player.getName(), balance.getBalance(), amount));
                            player.sendMessage(messages.getRemoveReceiverMsg(player.getName(), balance.getBalance(), amount));
                            return true;
                        case "set":
                            if (!sender.hasPermission("cropcoin.set")) {
                                sender.sendMessage(messages.getNoPermissionMsg());
                                return false;
                            }
                            balance.setBalance(amount);
                            sender.sendMessage(messages.getSetSenderMsg(player.getName(), balance.getBalance(), amount));
                            player.sendMessage(messages.getSetReceiverMsg(player.getName(), balance.getBalance(), amount));
                            return true;
                    }
                }
                break;
        }
        for (String line : messages.getCommandUsageMsg()) {
            sender.sendMessage(line);
        }
        return false;
    }

    /**
     * Check if sender used the correct command usage.
     *
     * @param arg0
     */
    private boolean hasCorrectUsage(String arg0) {
        if (arg0.equalsIgnoreCase("give") ||
            arg0.equalsIgnoreCase("remove") ||
            arg0.equalsIgnoreCase("set")) {
            return true;
        }
        return false;
    }
}
