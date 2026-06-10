import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart <= end) {
                // Overlapping intervals
                end = Math.max(end, currEnd);
            } else {
                // Non-overlapping interval
                merged.add(new int[]{start, end});
                start = currStart;
                end = currEnd;
            }
        }

        merged.add(new int[]{start, end});

        return merged.toArray(new int[merged.size()][]);
    }
}