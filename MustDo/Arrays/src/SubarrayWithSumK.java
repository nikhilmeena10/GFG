import java.util.Scanner;

public class SubarrayWithSumK {

    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int sum = 0;
            int start = 0, end = -1;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum == s) {
                    end = i;
                    break;
                } else if (sum > s) {
                    boolean found = false;
                    for (int j = start; j < i; j++) {
                        sum -= arr[j];
                        if (sum == s) {
                            start = j;
                            found = true;
                            break;
                        } else if (sum < s) {
                            start = j;
                            break;
                        }
                    }
                    if (found) break;
                }
            }
            if (end == -1) System.out.println(-1);
            else System.out.println(start + " " + end);
            t--;
        }
    }

}
