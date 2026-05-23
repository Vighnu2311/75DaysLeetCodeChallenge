import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        
        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // Add all stones to heap
        for (int stone : stones) {
            pq.offer(stone);
        }

        // Smash stones until one or none left
        while (pq.size() > 1) {
            int y = pq.poll(); // heaviest
            int x = pq.poll(); // second heaviest

            if (y != x) {
                pq.offer(y - x);
            }
        }

        // Return remaining stone or 0
        return pq.isEmpty() ? 0 : pq.poll();
    }
}