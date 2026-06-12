import java.util.*;

public class AGamesOnTheTrain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        while (t-- > 0) {
            int n = in.nextInt();
            int maxH = 0;
            int minH = 7; 
            for (int i = 0; i < n; i++) {
                int h = in.nextInt();
                if (h > maxH) {
                    maxH = h;
                }
                if (h < minH) {
                    minH = h;
                }
            }
            int ans = (maxH + 1) - minH;
            System.out.println(ans);
        }
    }
}