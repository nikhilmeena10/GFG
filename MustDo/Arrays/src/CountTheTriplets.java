import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//GFG also has a combinatorial solution with same complexity
public class CountTheTriplets {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t > 0) {
            int n = fs.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextLong();
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                long target = arr[i];
                Set<Long> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (j == i) continue;
                    if (set.contains(target - arr[j])) {
                        count++;
                    }
                    set.add(arr[j]);
                }
            }
            if (count == 0) System.out.println(-1);
            else System.out.println(count);
            t--;
        }
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }

}
