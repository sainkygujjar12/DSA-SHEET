package Arrays.greedy;

public  class fractionalKnapSack {
    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

        double maxValue = getMaxValue(values, weights, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }

    public static double getMaxValue(int[] values, int[] weights, int capacity) {
        ItemValue[] itemValues = new ItemValue[values.length];

        for (int i = 0; i < values.length; i++) {
            itemValues[i] = new ItemValue(values[i], weights[i], i);
        }

        // Sort items by value-to-weight ratio in descending order
        java.util.Arrays.sort(itemValues, (a, b) -> Double.compare(b.cost, a.cost));

        double totalValue = 0;

        for (ItemValue item : itemValues) {
            if (capacity - item.weight >= 0) {
                // If the item can be fully added
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                // If the item can't be fully added, add the fractional part
                totalValue += item.cost * capacity;
                break;
            }
        }

        return totalValue;
    }

    static class ItemValue {
        double value, weight, cost;

        public ItemValue(int value, int weight, int index) {
            this.value = value;
            this.weight = weight;
            this.cost = (double) value / weight;
        }
    }
    
}
