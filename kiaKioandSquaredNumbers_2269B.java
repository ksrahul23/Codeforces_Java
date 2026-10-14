import java.util.*;

public class kiaKioandSquaredNumbers_2269B {
    public static int getNext(int x) {
        int sum = 0;
        while (x > 0) {
            int digit = x % 10;
            sum += digit * digit;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] lh = new int[n];
            
            for (int i = 0; i < n; i++) {
                int val = scanner.nextInt();
                for (int day = 0; day < 40; day++) {
                    val = getNext(val);
                }
                lh[i] = val;
            }
            Arrays.sort(lh);
            
            long pairs = 0;
            long c = 1;
            for (int i = 1; i < n; i++) {
                if (lh[i] == lh[i - 1]) {
                    c++;
                } else {
                    pairs += (c * (c- 1)) / 2;
                    c = 1;
                }
            }
            pairs += (c * (c - 1)) / 2;
            System.out.println(pairs);
        }
    }
}