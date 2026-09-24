import java.util.Scanner;

public class goodContest_2266A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            int a3 = sc.nextInt();
            
            int maxStrong = Math.min(a1, Math.min(a2, a3));
            int minWeak = n - maxStrong;
            
            System.out.println(minWeak);
        }
    }
}