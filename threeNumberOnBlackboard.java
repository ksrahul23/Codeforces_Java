import java.util.Arrays;
import java.util.Scanner;

public class threeNumberOnBlackboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            long[] arr = new long[3];
            arr[0] = sc.nextLong();
            arr[1] = sc.nextLong();
            arr[2] = sc.nextLong();

            Arrays.sort(arr);
            long initialRange = arr[2] - arr[0];
            long oneOpRange = arr[1];

            System.out.println(Math.min(initialRange, oneOpRange));
        }
    }
}