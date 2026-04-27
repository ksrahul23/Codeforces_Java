import java.util.*;

public class A_A_Number_Between_Two_Others {
    static Scanner sc = new Scanner(System.in);
    static void solve() {
        int a = sc.nextInt();
        int b = sc.nextInt();           
        int c = sc.nextInt();
    
            if ((a < c && c < b) || (b < c && c < a)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }  
    }

    public static void main(String[] args) {
        int t = sc.nextInt();   
        while (t-- > 0) {
            solve();
        }
    }
}