import java.util.Scanner;

public class minMaxGame_2236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int countOnes = 0;
            
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                if (val == 1) {
                    countOnes++;
                }
            }
            if (countOnes >= 2 || (countOnes == 1 && n == 2)) {
                System.out.println("Bessie");
            } else {
                System.out.println("Elsie");
            }
        }
    }
}