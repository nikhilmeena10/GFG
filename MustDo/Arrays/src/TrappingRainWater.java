import java.io.*;
import java.util.StringTokenizer;

//better solution with O(1) spaces exists
//https://www.geeksforgeeks.org/trapping-rain-water/
public class TrappingRainWater {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        Print printer = new Print();
        int t = fs.nextInt();
        while (t > 0) {
            int n = fs.nextInt();
            int[] arr = new int[n];
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
                nodes[i] = new Node();
            }
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    nodes[i].left = arr[i];
                } else {
                    if (arr[i] > nodes[i - 1].left) {
                        nodes[i].left = arr[i];
                    } else {
                        nodes[i].left = nodes[i - 1].left;
                    }
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (i == n - 1) {
                    nodes[i].right = arr[i];
                } else {
                    if (arr[i] > nodes[i + 1].right) {
                        nodes[i].right = arr[i];
                    } else {
                        nodes[i].right = nodes[i + 1].right;
                    }
                }
            }
            int val = 0;
            for (int i = 0; i < n; i++) {
                val += Math.min(nodes[i].left, nodes[i].right) - arr[i];
            }
            printer.println(val);
            t--;
        }
        printer.close();
    }

    static class Node {
        int left, right;
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
