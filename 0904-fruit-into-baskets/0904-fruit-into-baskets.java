class Solution {
    public int totalFruit(int[] fruits) {
        int lastFruit = -1;
        int secondLastFruit = -1;

        int lastFruitCount = 0;
        int currentMax = 0;
        int max = 0;

        for (int fruit : fruits) {

            // Extend current window if fruit matches
            if (fruit == lastFruit || fruit == secondLastFruit) {
                currentMax++;
            } else {
                // Start new window with last consecutive fruits
                currentMax = lastFruitCount + 1;
            }

            // Count consecutive lastFruit occurrences
            if (fruit == lastFruit) {
                lastFruitCount++;
            } else {
                lastFruitCount = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            max = Math.max(max, currentMax);
        }

        return max;
    }
}