import java.util.*;

public class D_The_67_th_OEIS_Problem {
    static Scanner sc = new Scanner(System.in);

    static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++)
            if (x % i == 0) return false;
        return true;
    }

    static List<Integer> getPrimes(int n) {
        List<Integer> p = new ArrayList<>();
        for (int i = 2; p.size() < n; i++)
            if (isPrime(i)) p.add(i);
        return p;
    }
    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> primes = getPrimes(n);

            long[] a = new long[n];
            if (n > 0) a[0] = 1;
            if (n > 1) a[1] = primes.get(0);

            for (int i = 2; i < n; i++)
                a[i] = 1L * primes.get(i - 2) * primes.get(i - 1);

            for (long x : a) System.out.print(x + " ");
            System.out.println();
        }
    }
}