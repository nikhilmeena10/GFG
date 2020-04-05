import java.io.*;
import java.util.StringTokenizer;

public class ReverseArrayInGroups {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        Print printer = new Print();
        int t = fs.nextInt();
        while (t > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextLong();
            }
            int i = 0;
            for (; i + k < n; i += k) {
                int j = i;
                int oi = i + k - 1;
                while (j <= oi) {
                    long tmp = arr[j];
                    arr[j] = arr[oi];
                    arr[oi] = tmp;
                    j++;
                    oi--;
                }
            }
            int j = i, m = n - 1;
            while (j <= m) {
                long tmp = arr[j];
                arr[j] = arr[m];
                arr[m] = tmp;
                j++;
                m--;
            }
            for (int l = 0; l < n; l++) {
                printer.print(arr[l] + " ");
            }
            printer.print('\n');
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
