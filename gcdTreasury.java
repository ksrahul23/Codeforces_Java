import java.util.*;

public class Main {
    static long[] sumB = new long[300001];
    static boolean[] reachable = new boolean[300001];
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            ArrayList<Integer> presentDivs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int g = gcd(a, x);
                if (sumB[g] == 0) {
                    presentDivs.add(g);
                }
                sumB[g] += a;
            }
            ArrayList<Integer> divs = new ArrayList<>();
            for (int i = 1; i * i <= x; i++) {
                if (x % i == 0) {
                    divs.add(i);
                    if (i * i != x) {
                        divs.add(x / i);
                    }
                }
            }
            Collections.sort(divs, Collections.reverseOrder());
            reachable[x] = true;
            long maxCoins = 0;
            for (int d : divs) {
                if (!reachable[d]) continue;
                if (d > 1) {
                    long currentCoins = 0;
                    for (int v : presentDivs) {
                        if (v % d == 0) {
                            currentCoins += sumB[v];
                        }
                    }
                    if (currentCoins > maxCoins) {
                        maxCoins = currentCoins;
                    }
                }
                for (int v : presentDivs) {
                    if (v % d != 0) {
                        reachable[gcd(d, v)] = true;
                    }
                }
            }

            out.append(maxCoins).append("\n");
            for (int v : presentDivs) {
                sumB[v] = 0;
            }
            for (int d : divs) {
                reachable[d] = false;
            }
        }
        System.out.print(out);
    }
}