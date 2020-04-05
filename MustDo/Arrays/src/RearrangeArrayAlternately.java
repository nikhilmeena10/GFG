import java.io.*;
import java.util.StringTokenizer;

public class RearrangeArrayAlternately {

    //Interesting solution on gfg
    //https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form-set-2-o1-extra-space/
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        Print printer = new Print();
        int t = fs.nextInt();
        while (t > 0) {
            int n = fs.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
            }
            int maxi = n - 1;
            int mini = 0;
            int maxe = arr[maxi] + 1;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] += (arr[maxi] % maxe) * maxe;
                    maxi--;
                } else {
                    arr[i] += (arr[mini] % maxe) * maxe;
                    mini++;
                }
            }
            for (int i = 0; i < n; i++) {
                printer.print(arr[i] / maxe + " ");
            }
            printer.print('\n');
            t--;
        }
        printer.close();
    }

    //My solution: O(n^2) not good
    /*public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        Print printer = new Print();
        int t = fs.nextInt();
        while (t > 0) {
            int n = fs.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
            }
            //rotate array by 1 towards right, each time n/k length k--> 1 to n
            int start = 0;
            while (start < n) {
                int pop = arr[n - 1];
                for (int i = n - 1; i > start; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[start] = pop;
                start += 2;
            }
            for (int i = 0; i < n; i++) {
                printer.print(arr[i] + " ");
            }
            printer.print('\n');
            t--;
        }
        printer.close();
    }*/

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
