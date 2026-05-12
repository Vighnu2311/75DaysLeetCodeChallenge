public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            // Prevent overflow
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid; // first bad is at mid or before
            } else {
                left = mid + 1; // first bad is after mid
            }
        }

        return left;
    }
}