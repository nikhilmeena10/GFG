import java.io.*;
import java.util.StringTokenizer;

public class Sort012 {

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
            int lo = 0, mid = 0, hi = n - 1;
            while (mid <= hi) {
                if (arr[mid] == 0) {
                    if (arr[lo] == 0) {
                        lo++;
                        mid++;
                    } else {
                        long tmp = arr[lo];
                        arr[lo] = arr[mid];
                        arr[mid] = tmp;
                        lo++;
                        mid++;
                    }
                } else if (arr[mid] == 1) {
                    mid++;
                } else {
                    if (arr[hi] == 2) {
                        hi--;
                    } else {
                        long tmp = arr[mid];
                        arr[mid] = arr[hi];
                        arr[hi] = tmp;
                        hi--;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                printer.print(arr[i] + " ");
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
