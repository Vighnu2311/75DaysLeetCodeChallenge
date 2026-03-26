class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int windowSum = 0;

        // Step 1: first window sum
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // Step 2: slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i];      // add next
            windowSum -= nums[i - k];  // remove leftmost

            maxSum = Math.max(maxSum, windowSum);
        }

        // Step 3: calculate average
        return (double) maxSum / k;
    }
}