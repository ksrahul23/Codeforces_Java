import java.util.*;

public class C2WeBeFlippingHardVersion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextLong();
            }
            long[] p = new long[n + 2];
            for (int i = 1; i <= n; i++) {
                p[i] = p[i - 1] + Math.abs(a[i]);
            }
            long[] s = new long[n + 2];
            for (int i = n; i >= 1; i--) {
                s[i] = s[i + 1] + a[i];
            }
            long mx = s[1];
            int bM = 0;
            for (int i = 1; i <= n; i++) {
                if (a[i] > 0) {
                    long cur = p[i - 1] - a[i] + s[i + 1];
                    if (cur > mx) {
                        mx = cur;
                        bM = i;
                    }
                }
            }
            if (bM == 0) {
                out.append("0\n\n");
            } else {
                int[] c = new int[n + 2];
                c[bM] = 1;
                for (int i = bM - 1; i >= 1; i--) {
                    if (a[i] < 0) c[i] = 1;
                    else c[i] = 0;
                }
                ArrayList<Integer> S = new ArrayList<>();
                for (int i = bM; i >= 1; i--) {
                    if (c[i] != c[i + 1]) {
                        S.add(i);
                    }
                }
                LinkedList<Integer> q = new LinkedList<>();
                q.add(S.get(0));
                for (int i = 1; i < S.size(); i++) {
                    int x = S.get(i);
                    if (a[x] > 0) {
                        q.addFirst(x);
                    } else {
                        q.add(1, x);
                    }
                }
                out.append(q.size()).append("\n");
                for (int x : q) {
                    out.append(x).append(" ");
                }
                out.append("\n");
            }
        }
        System.out.print(out);
    }
}