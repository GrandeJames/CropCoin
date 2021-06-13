package me.finest.cropcoin.cropcoin.utils;

import org.bukkit.ChatColor;

public class Color {

    /**
     * Translate the message with colors.
     *
     * @param message The message to translate.
     * @return The translated message.
     */
    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
