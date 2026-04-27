import java.util.*;

public class BArtisticBalanceTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            long totalSum = 0;
            List<Long> odds = new ArrayList<>();
            List<Long> evens = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                long val = sc.nextLong();
                totalSum += val;
                if (i % 2 != 0) odds.add(val);
                else evens.add(val);
            }
            int countOdd = 0;
            int countEven = 0;
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                if (x % 2 != 0) countOdd++;
                else countEven++;
            }
            Collections.sort(odds, Collections.reverseOrder());
            Collections.sort(evens, Collections.reverseOrder());
            
            long markedSum = 0;
            
            if (countOdd > 0 && !odds.isEmpty()) {
                markedSum += odds.get(0);
                for (int i = 1; i < Math.min(countOdd, odds.size()); i++) {
                    if (odds.get(i) > 0) markedSum += odds.get(i);
                    else break;
                }
            }
            
            if (countEven > 0 && !evens.isEmpty()) {
                markedSum += evens.get(0);
                for (int i = 1; i < Math.min(countEven, evens.size()); i++) {
                    if (evens.get(i) > 0) markedSum += evens.get(i);
                    else break;
                }
            }
            
            System.out.println(totalSum - markedSum);
        }
    }
}