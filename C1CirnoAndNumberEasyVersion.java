import java.io.*;
import java.util.*;

public class C1CirnoAndNumberEasyVersion {
    static long[][] cache = new long[100][];
    static long[] tempBuffer = new long[600000];
    static long[] getValidNumbers(int d1, int d2) {
        int key = d1 * 10 + d2;
        if (cache[key] != null) return cache[key];
        
        int size = 0;
        
        if (d1 == 0) {
            tempBuffer[size++] = 0;
            tempBuffer[size++] = d2;
        } else {
            tempBuffer[size++] = d1;
            tempBuffer[size++] = d2;
        }
        
        int head = 0;
        while (head < size) {
            long u = tempBuffer[head++];
            if (u == 0) continue;
            if (u > 100_000_000_000_000_000L) continue;
            
            long v1 = u * 10 + d1;
            long v2 = u * 10 + d2;
            
            tempBuffer[size++] = v1;
            tempBuffer[size++] = v2;
        }
        long[] res = Arrays.copyOf(tempBuffer, size);
        Arrays.sort(res);
        cache[key] = res;
        return res;
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int t = in.nextInt();
        if (t == -1) return; // EOF guard
        
        StringBuilder out = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            long a = in.nextLong();
            int n = in.nextInt();
            int d1 = in.nextInt();
            int d2 = in.nextInt();
            
            long[] arr = getValidNumbers(d1, d2);
            
            int idx = Arrays.binarySearch(arr, a);
            if (idx >= 0) {
                out.append(0).append("\n");
            } else {
                idx = -idx - 1; 
                long minDiff = Long.MAX_VALUE;
                if (idx < arr.length) {
                    minDiff = Math.min(minDiff, Math.abs(arr[idx] - a));
                }
                if (idx - 1 >= 0) {
                    minDiff = Math.min(minDiff, Math.abs(arr[idx - 1] - a));
                }
                out.append(minDiff).append("\n");
            }
        }
        System.out.print(out.toString());
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { 
            String n = next();
            return (n == null) ? -1 : Integer.parseInt(n); 
        }
        
        long nextLong() { 
            String n = next();
            return (n == null) ? -1 : Long.parseLong(n); 
        }
    }
}