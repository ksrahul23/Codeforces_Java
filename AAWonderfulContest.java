import java.util.Scanner;

public class AAWonderfulContest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean hasHundred = false;
            
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                if (a == 100) {
                    hasHundred = true;
                }
            }
            
            if (hasHundred) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        sc.close();
    }
}