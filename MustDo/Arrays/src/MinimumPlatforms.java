import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinimumPlatforms {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        Print printer = new Print();
        int t = fs.nextInt();
        while (t > 0) {
            int n = fs.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = fs.nextInt();
            }
            for (int i = 0; i < n; i++) {
                y[i] = fs.nextInt();
            }
            Arrays.sort(x);
            Arrays.sort(y);
            int xi = 0, yi = 0;
            int count = 0, max = 0;
            while (xi < n && yi < n) {
                if (x[xi] <= y[yi]) {
                    xi++;
                    count++;
                    max = Math.max(max, count);
                } else {
                    yi++;
                    count--;
                }
            }
            while (xi < n) {
                xi++;
                count++;
                max = Math.max(count, max);
            }
            while (yi < n) {
                yi++;
                count--;
            }
            printer.println(max);
            t--;
        }
        printer.close();
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

    static class Print {
        private final BufferedWriter bw;

        public Print() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

}
