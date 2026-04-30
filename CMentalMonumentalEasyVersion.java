import java.util.Scanner;
import java.util.Arrays;

public class CMentalMonumentalEasyVersion {
    static int[] cnt = new int[1000005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                    if (a[i] < 1000005) {
                        cnt[a[i]]++;
                    }
                }
                Arrays.sort(a);
                int low = 1, high = n, ans = 1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (check(mid, n, a)) {
                        ans = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                System.out.println(ans);
                for (int x : a) {
                    if (x < 1000005) {
                        cnt[x] = 0;
                    }
                }
            }
        }
    }

    static boolean check(int k, int n, int[] a) {
        int mCount = 0;
        for (int i = 0; i < k; i++) {
            if (cnt[i] == 0) mCount++;
        }
        if (mCount == 0) return true;
        
        int[] missing = new int[mCount];
        int mIdx = 0;
        for (int i = 0; i < k; i++) {
            if (cnt[i] == 0) missing[mIdx++] = i;
        }

        int mPtr = 0;
        int lastVal = -1;
        for (int i = 0; i < n; i++) {
            int val = a[i];
            boolean isExtra = false;
            if (val >= k) {
                isExtra = true;
            } else {
                if (val == lastVal) {
                    isExtra = true;
                } else {
                    lastVal = val;
                }
            }

            if (isExtra && mPtr < mCount) {
                if (val >= 2 * missing[mPtr] + 1) {
                    mPtr++;
                }
            }
        }
        return mPtr == mCount;
    }
}