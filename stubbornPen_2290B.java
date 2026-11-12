import java.util.*;
public class stubbornPen_2290B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            
            char currentPen = 'R';
            int switches = 0;
            
            for (int i = 0; i < n; i++) {
                char needed = s.charAt(i);
                if (currentPen != needed) {
                    switches++;
                }
                currentPen = (needed == 'R') ? 'B' : 'R';
            }
            System.out.println(switches);
        }
    }
}