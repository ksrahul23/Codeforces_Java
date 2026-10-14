import java.util.Scanner;

public class perfectSandwiches_2276A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a <= b) {
                System.out.println(-1);
            } else {
                System.out.println(Math.min(b, a - b));
            }
        }
    }
}