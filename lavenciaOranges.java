import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int C = 1;
            while (true) {
                long maxOranges = 0;
                for (int i = 1; i <= C; i++) {
                    maxOranges += (long) i * (C / i);
                }
                if (maxOranges >= n) {
                    break;
                }
                C++;
            }
            out.append(C).append("\n");
            int remainder = n;
            int bagId = 1;
            int[] ans = new int[n];
            int idx = 0;
            for (int size = C; size >= 1; size--) {
                int take = Math.min(C / size, remainder / size);
                
                for (int k = 0; k < take; k++) {
                    for (int j = 0; j < size; j++) {
                        ans[idx++] = bagId;
                    }
                    bagId++;
                }
                remainder -= take * size;
            }
            for (int i = 0; i < n; i++) {
                out.append(ans[i]).append(i == n - 1 ? "" : " ");
            }
            out.append("\n");
        }
        System.out.print(out);
    }
}