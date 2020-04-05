import java.io.*;
import java.util.StringTokenizer;

public class MissingNumberInArray {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t > 0) {
            int n = fs.nextInt();
            int m = n - 1;
            int[] arr = new int[m];
            for (int i = 0; i < m; i++) {
                arr[i] = fs.nextInt();
            }
            int xor = 0;
            for (int i = 0; i < m; i++) {
                xor = xor ^ (i + 1) ^ arr[i];
            }
            xor ^= n;
            System.out.println(xor);
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
