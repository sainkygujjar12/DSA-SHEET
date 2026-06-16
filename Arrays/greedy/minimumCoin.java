package Arrays.greedy;

public class minimumCoin {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = minCoins(coins, amount);
        System.out.println("Minimum coins required: " + result);
    }

    public static int minCoins(int[] coins, int amount) {
        // Sort the coins in descending order
        java.util.Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }
        return count;
    }
}
