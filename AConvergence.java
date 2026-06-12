import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                }
                Arrays.sort(a);
                int sixseven = 0;
                int l = 0;
                int r = n - 1;
                while (l < r) {
                    if (a[l] == a[r]) {
                        break;
                    }
                    sixseven++;
                    l++;
                    r--;
                }
                System.out.println(sixseven);
            }
        }
    }
}