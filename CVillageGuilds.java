import java.util.Scanner;

public class CVillageGuilds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                p[i] = sc.nextInt();
            }
            int[] depth = new int[n + 1];
            int[] md = new int[n + 1];
            int[] M1 = new int[n + 1];
            int[] M2 = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                M1[i] = -1;
                M2[i] = -1;
                md[i] = 0;
            }
            depth[1] = 0;
            for (int i = 2; i <= n; i++) {
                depth[i] = depth[p[i]] + 1;
            }
            for (int i = 1; i <= n; i++) {
                md[i] = depth[i];
            }
            for (int i = n; i >= 2; i--) {
                int parent = p[i];
                if (md[i] > M1[parent]) {
                    M2[parent] = M1[parent];
                    M1[parent] = md[i];
                } else if (md[i] > M2[parent]) {
                    M2[parent] = md[i];
                }
                if (md[i] > md[parent]) {
                    md[parent] = md[i];
                }
            }
            long total = n; 
            for (int i = 1; i <= n; i++) {
                if (M2[i] != -1) {
                    total += Math.max(0, M2[i] - depth[i]);
                }
            }
            System.out.println(total);
        }
    }
}