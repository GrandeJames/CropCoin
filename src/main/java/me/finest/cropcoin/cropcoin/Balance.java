/**
 * This may be used to modify a player's balance.
 * This can give, remove, or set.
 */

package me.finest.cropcoin.cropcoin;

public class Balance {

    private String uuid;
    private int balance;

    public Balance(String uuid) {
        this(0, uuid);
    }

    public Balance(int balance, String uuid) {

        this.setUUID(uuid);
        this.setBalance(balance);
    }


    /**
     * Get player's crop coin balance.
     *
     * @return The player's cropCoin balance.
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * Get the player's uuid.
     *
     * @return The player's uuid.
     */
    public String getUUID() {
        return this.uuid;
    }


    /**
     * Set the player's uuid.
     *
     * @param uuid The player's uuid.
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


    /**
     * Add to the player's cropCoin balance.
     *
     * @param amtToGive The number of cropCoins to add.
     */
    public void give(int amtToGive) {
        setBalance(getBalance() + amtToGive);
    }

    /**
     * Remove a certain amount from the player's cropCoin balance.
     *
     * @param amtToRemove The number of cropCoins to remove.
     */
    public void remove(int amtToRemove) {
        // Remove from the player's balance, but don't go to less than 0.
        if (setBalance(getBalance() - amtToRemove) < 0) {
            setBalance(0);
        }
    }
}
