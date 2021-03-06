import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SubarrayWithSumK {

    public static void main(String[] args) {
        //code
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t > 0) {
            int n = fs.nextInt();
            long s = fs.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextLong();
            }
            long sum = 0;
            int start = 0, end = -1;
            Map<Long, Integer> map = new HashMap<>();
            map.put(0L, -1);
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (map.containsKey(sum - s)) {
                    start = map.get(sum - s) + 1;
                    end = i;
                    break;
                }
                map.put(sum, i);
            }
            if (end == -1) System.out.println(-1);
            else System.out.println((start + 1) + " " + (end + 1));
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
