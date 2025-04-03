import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // N(1 ≤ N ≤ 2,000)
        int ans = 0;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // nlogn

        for (int i = 0; i < n; i++) {
            int target = arr[i];
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int sum = arr[left] + arr[right];

                if (sum == target) {
                    if (left != i && right != i) {
                        ans++;
                        break;
                    } else if (left == i) {
                        left++;
                    } else {
                        right--;
                    }

                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
    }

}