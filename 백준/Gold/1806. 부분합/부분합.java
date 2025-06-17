import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수열 길이. 10 이상 10만 이하
        int S = Integer.parseInt(st.nextToken()); // 부분합. 0 이상 1억 이하

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        int[] aSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            aSum[i] = aSum[i - 1] + arr[i];
        }

        int s = 1, e = 1;
        int ans = N + 1;
        while (s <= N && e <= N) {
            if (aSum[e] - aSum[s - 1] >= S) { // s번째부터 e번째까지 부분합이 S 이상이다?
                ans = Math.min(ans, e - s + 1);
                s += 1;
            } else {
                // e를 늘림
                e += 1;
            }
        }

        System.out.println(ans == N + 1 ? 0 : ans);
    }
}
