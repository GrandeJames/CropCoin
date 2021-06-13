/**
 * This may be used to modify a player's balance.
 * This can give, remove, set, or pay.
 */

package me.finest.cropcoin.cropcoin;

public class Balance {

    // Properties
    private String uuid;
    private int balance;

    private final CropCoin plugin;

    /**
     * Constructor
     */
    public Balance(String uuid, CropCoin plugin) {
        this(0, uuid, plugin);
    }

    /**
     * Constructor
     */
    public Balance(int balance, String uuid, CropCoin plugin) {
        this.plugin = plugin;

        this.setUUID(uuid);
        this.setBalance(balance);
    }


    // Getters


    /**
     * Get player's cropCoin balance.
     *
     * @return The player's cropCoin balance.
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * Ge the player's uuid.
     *
     * @return The player's uuid.
     */
    public String getUUID() {
        return this.uuid;
    }


    // Setters


    /**
     * Set the player's uuid.
     */
    private void setUUID(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Set the player's cropCoin balance.
     *
     * @param balance The number to set the player's balance to.
     * @return The player's new balance.
     */
    public int setBalance(int balance) {
        this.balance = balance;
        return getBalance();
    }


    // Other


    /**
     * Add to the player's cropCoin balance.
     *
     * @param amtToGive The number of cropCoin to add.
     */
    public void give(int amtToGive) {
        setBalance(getBalance() + amtToGive);
    }

    /**
     * Remove a certain amount from the player's cropCoin balance.
     *
     * @param amtToRemove The number of cropCoin to remove.
     */
    public void remove(int amtToRemove) {
        if (setBalance(getBalance() - amtToRemove) < 0) {
            setBalance(0);
        }
    }

    /**
     * Give another player's cropCoin balance to another.
     *
     * @param amtToPay The amount of cropCoin to pay.
     * @param giverBalance The giver's cropCoin balance.
     */
    public void pay(int amtToPay, Balance giverBalance) {
        giverBalance.remove(amtToPay);
        give(amtToPay);
    }
}
