import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
                    
                int sum = 0;
           int count = 0;
                                            
             // Important: base case
            map.put(0, 1);
                                                                    
             for (int num : nums) {
                sum += num;
                                                                                                    
                                                                                                                // If (sum - k) exists, add its frequency
                                                                                                                            if (map.containsKey(sum - k)) {
                                                                                                                                            count += map.get(sum - k);
                                                                                                                                                        }
                                                                                                                                                                    
                                                                                                                                                                                // Store current sum frequency
                                                                                                                                                                                            map.put(sum, map.getOrDefault(sum, 0) + 1);
                                                                                                                                                                                                    }
                                                                                                                                                                                                            
                                                                                                                                                                                                                    return count;
                                                                                                                                                                                                                        }
                                                                                                                                                                                       }