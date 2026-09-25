import java.util.*;

public class fashionableArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int[] count = new int[101];
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                count[val]++;
            }
            ArrayList<Integer> result = new ArrayList<>(n);
            int remaining = n;

            while (remaining > 0) {
                for (int v = 100; v >= 1; v--) {
                    if (count[v] > 0) {
                        result.add(v);
                        count[v]--;
                        remaining--;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(result.get(i) + (i == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}