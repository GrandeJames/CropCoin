package me.finest.cropcoin.cropcoin.utils;

import java.util.List;

public class Messages {

    //Messages
    private String invalidPlayerMsg;
    private String invalidAmtMsg;
    private String noPermissionMsg;
    private List<String> commandUsageMsg;
    private String giveSenderMsg;
    private String giveReceiverMsg;
    private String removeSenderMsg;
    private String removeReceiverMsg;
    private String setSenderMsg;
    private String setReceiverMsg;
    private String balanceSenderMsg;
    private String balanceReceiverMsg;
    private String notPlayerMsg;

    /**
     * Constructor
     */
    public Messages(String invalidPlayerMsg, String invalidAmtMsg, String noPermissionMsg, List<String> commandUsageMsg,
                    String giveSenderMsg, String giveReceiverMsg, String removeSenderMsg, String removeReceiverMsg,
                    String setSenderMsg, String setReceiverMsg, String balanceSenderMsg, String balanceReceiverMsg,
                    String notPlayerMsg) {
        // Initialize the messages.
        setInvalidPlayerMsg(invalidPlayerMsg);
        setInvalidAmtMsg(invalidAmtMsg);
        setNoPermissionMsg(noPermissionMsg);
        setCommandUsageMsg(commandUsageMsg);
        setGiveSenderMsg(giveSenderMsg);
        setGiveReceiverMsg(giveReceiverMsg);
        setRemoveSenderMsg(removeSenderMsg);
        setRemoveReceiverMsg(removeReceiverMsg);
        setSetSenderMsg(setSenderMsg);
        setSetReceiverMsg(setReceiverMsg);
        setBalanceSenderMsg(balanceSenderMsg);
        setBalanceReceiverMsg(balanceReceiverMsg);
        setNotPlayerMsg(notPlayerMsg);
    }

    // Getters

    /**
     * Get the invalid-player message.
     *
     * @return The invalid-player message.
     */
    public String getInvalidPlayerMsg() {
        return Color.color(this.invalidPlayerMsg);
    }

    /**
     * Get the invalid-amount message.
     *
     * @return The invalid-amount message.
     */
    public String getInvalidAmtMsg() {
        return Color.color(this.invalidAmtMsg);
    }

    /**
     * Get the no-permission message.
     *
     * @return The no-permission message.
     */
    public String getNoPermissionMsg() {
        return Color.color(this.noPermissionMsg);
    }

    /**
     * Get the command-usage message.
     *
     * @return The command-usage message.
     */
    public List<String> getCommandUsageMsg() {
        for (int i = 0; i < this.commandUsageMsg.size(); i++) {
            commandUsageMsg.set(i, Color.color(this.commandUsageMsg.get(i)));
        }
        return this.commandUsageMsg;
    }

    /**
     * Get the give-sender message.
     *
     * @return The give-sender message.
     */
    public String getGiveSenderMsg(String receiverName, int balance, int amount) {
        return this.replace(this.giveSenderMsg, receiverName, balance, amount);
    }

    /**
     * Get the give-receiver message.
     *
     * @return The give-receiver message.
     */
    public String getGiveReceiverMsg(String receiverName, int balance, int amount) {
        return this.replace(this.giveReceiverMsg, receiverName, balance, amount);
    }

    /**
     * Get the remove-sender message.
     *
     * @return The remove-sender message.
     */
    public String getRemoveSenderMsg(String receiverName, int balance, int amount) {
        return this.replace(this.removeSenderMsg, receiverName, balance, amount);
    }

    /**
     * Get the remove-receiver message.
     *
     * @return The remove-receiver message.
     */
    public String getRemoveReceiverMsg(String receiverName, int balance, int amount) {
        return this.replace(this.removeReceiverMsg, receiverName, balance, amount);
    }

    /**
     * Get the set-sender message.
     *
     * @return The set-sender message.
     */
    public String getSetSenderMsg(String receiverName, int balance, int amount) {
        return this.replace(this.setSenderMsg, receiverName, balance, amount);
    }

    /**
     * Get the set-receiver message.
     *
     * @return The set-receiver message.
     */
    public String getSetReceiverMsg(String receiverName, int balance, int amount) {
        return this.replace(this.setReceiverMsg, receiverName, balance, amount);
    }

    /**
     * Get the balance-sender message.
     *
     * @param balance The sender's crop coin balance.
     * @return The balance-sender message.
     */
    public String getBalanceSenderMsg(int balance) {
        return Color.color(this.balanceSenderMsg).replaceAll("%balance%", String.valueOf(balance));
    }

    /**
     * Get the balance-receiver message.
     *
     * @param balance The receiver's crop coin balance.
     * @param receiverName The receiver's name.
     * @return The balance-receiver message.
     */
    public String getBalanceReceiverMsg(int balance, String receiverName) {
        String color = Color.color(this.balanceReceiverMsg);
        String replaceBalance = color.replaceAll("%receiver_balance%", String.valueOf(balance));
        return replaceBalance.replaceAll("%receiver_name%", receiverName);
    }

    /**
     * Get the not-a-player message.
     *
     * @return The not-a-player message.
     */
    public String getNotPlayerMsg() {
        return Color.color(this.notPlayerMsg);
    }

    // Setters

    /**
     * Set the invalid-player message.
     *
     * @param invalidPlayerMsg The invalid-player message to set to.
     */
    public void setInvalidPlayerMsg(String invalidPlayerMsg) {
        this.invalidPlayerMsg = invalidPlayerMsg;
    }

    /**
     * Set the invalid-amount message.
     *
     * @param invalidAmtMsg The invalid-amount message to set to.
     */
    public void setInvalidAmtMsg(String invalidAmtMsg) {
        this.invalidAmtMsg = invalidAmtMsg;
    }

    /**
     * Set the no-permission message.
     *
     * @param noPermissionMsg The no-permission message to set to.
     */
    public void setNoPermissionMsg(String noPermissionMsg) {
        this.noPermissionMsg = noPermissionMsg;
    }

    /**
     * Set the command-usage message.
     *
     * @param commandUsageMsg The command-usage message to set to.
     */
    public void setCommandUsageMsg(List<String> commandUsageMsg) {
        this.commandUsageMsg = commandUsageMsg;
    }

    /**
     * Set the give-sender message.
     *
     * @param giveSenderMsg The give-sender message to set to.
     */
    public void setGiveSenderMsg(String giveSenderMsg) {
        this.giveSenderMsg = giveSenderMsg;
    }

    /**
     * Set the give-receiver message.
     *
     * @param giveReceiverMsg The give-receiver message to set to.
     */
    public void setGiveReceiverMsg(String giveReceiverMsg) {
        this.giveReceiverMsg = giveReceiverMsg;
    }

    /**
     * Set the remove-sender message.
     *
     * @param removeSenderMsg The remove-sender message to set to.
     */
    public void setRemoveSenderMsg(String removeSenderMsg) {
        this.removeSenderMsg = removeSenderMsg;
    }

    /**
     * Set the remove-receiver message.
     *
     * @param removeReceiverMsg The remove-receiver message to set to.
     */
    public void setRemoveReceiverMsg(String removeReceiverMsg) {
        this.removeReceiverMsg = removeReceiverMsg;
    }

    /**
     * Set the set-sender message.
     *
     * @param setSenderMsg The set-sender message to set to.
     */
    public void setSetSenderMsg(String setSenderMsg) {
        this.setSenderMsg = setSenderMsg;
    }

    /**
     * Set the set-receiver message.
     *
     * @param setReceiverMsg The set-receiver message to set to.
     */
    public void setSetReceiverMsg(String setReceiverMsg) {
        this.setReceiverMsg = setReceiverMsg;
    }

    /**
     * Set the balance-sender message.
     *
     * @param balanceSenderMsg The balance-sender message to set to.
     */
    public void setBalanceSenderMsg(String balanceSenderMsg) {
        this.balanceSenderMsg = balanceSenderMsg;
    }

    /**
     * Set the balance-receiver message.
     *
     * @param balanceReceiverMsg The balance-receiver message.
     */
    public void setBalanceReceiverMsg(String balanceReceiverMsg) {
        this.balanceReceiverMsg = balanceReceiverMsg;
    }

    /**
     * Set the not-a-player message.
     *
     * @param notPlayerMsg The not-a-player message.
     */
    public void setNotPlayerMsg(String notPlayerMsg) {
        this.notPlayerMsg = notPlayerMsg;
    }

    // Other

    /**
     * Replace the receiver-name and/or balance and return the message.
     *
     * @param message The message to replace.
     * @param receiverName The receiver's name.
     * @param balance The receiver's balance.
     * @return The replaced message.
     */
    private String replace(String message, String receiverName, int balance, int amount) {
        String color = Color.color(message);
        String replaceAllReceiverName = color.replaceAll("%receiver_name%", receiverName);
        String replaceAllBalance = replaceAllReceiverName.replaceAll("%receiver_balance%", String.valueOf(balance));

        return replaceAllBalance.replaceAll("%amount%", String.valueOf(amount));
    }
}
