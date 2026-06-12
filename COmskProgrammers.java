import java.util.*;

public class COmskProgrammers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long x = sc.nextLong();
            ArrayList<Long> seqA = new ArrayList<>();
            seqA.add(a);
            while (a > 0) {
                a /= x;
                seqA.add(a);
            }
            ArrayList<Long> seqB = new ArrayList<>();
            seqB.add(b);
            while (b > 0) {
                b /= x;
                seqB.add(b);
            }
            long minOps = Long.MAX_VALUE;
            for (int i = 0; i < seqA.size(); i++) {
                for (int j = 0; j < seqB.size(); j++) {
                    long valA = seqA.get(i);
                    long valB = seqB.get(j);
                    long currOps = i + j + Math.abs(valA - valB);
                    if (currOps < minOps) {
                        minOps = currOps;
                    }
                }
            }
            System.out.println(minOps);
        }
    }
}