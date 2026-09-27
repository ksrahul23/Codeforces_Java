import java.util.*;

public class Main {
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
            int[] lighthouses = new int[n];
            
            for (int i = 0; i < n; i++) {
                int val = scanner.nextInt();
                for (int day = 0; day < 200; day++) {
                    val = getNext(val);
                }
                lighthouses[i] = val;
            }
            Arrays.sort(lighthouses);
            
            long totalPairs = 0;
            long count = 1;
            for (int i = 1; i < n; i++) {
                if (lighthouses[i] == lighthouses[i - 1]) {
                    count++;
                } else {
                    totalPairs += (count * (count - 1)) / 2;
                    count = 1;
                }
            }
            totalPairs += (count * (count - 1)) / 2;
            System.out.println(totalPairs);
        }
    }
}