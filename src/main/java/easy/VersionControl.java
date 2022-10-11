package easy;

public class VersionControl {

    public int firstBadVersion(int n) {
        int left = 1;
        while (left <= n) {
            int mid = (n - left - 1) / 2 + left;
            if (isBadVersion(mid)) {
                n = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isBadVersion(int version) {
        return true;
    }

}
