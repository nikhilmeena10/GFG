import java.io.*;
import java.util.StringTokenizer;

public class EquilibriumPoint {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        Print printer = new Print();
        int t = fs.nextInt();
        while (t > 0) {
            int n = fs.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextLong();
            }
            long leftsum = arr[0], rightsum = 0;
            for (int i = 1; i < n; i++) {
                rightsum += arr[i];
            }
            int i = 0;
            boolean possible = false;
            if (rightsum == 0) printer.println(1);
            else {
                for (i = 1; i < n; i++) {
                    rightsum -= arr[i];
                    if (leftsum == rightsum) {
                        possible = true;
                        break;
                    }
                    leftsum += arr[i];
                }
                if (possible) printer.println(i + 1);
                else printer.println(-1);
            }
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
