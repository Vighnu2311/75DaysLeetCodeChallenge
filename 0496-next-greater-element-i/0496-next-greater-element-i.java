import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Stores next greater element for each value
        HashMap<Integer, Integer> map = new HashMap<>();

        // Monotonic decreasing stack
        Deque<Integer> stack = new ArrayDeque<>();

        // Process nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());

            stack.push(nums2[i]);
        }

        // Build answer for nums1
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}