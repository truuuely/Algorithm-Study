import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N 개 물건 (1 <= N <= 100)
        int K = Integer.parseInt(st.nextToken()); // 버틸만한 무게 (1 <= K <= 100,000)

        int[] dp = new int[K + 1]; // arr[i] = 용량이 j인 배낭의 최대 가치
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // W(1 <= W <= 100_000), V (0 <= V <= 1000)
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            for (int j = K; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }

        System.out.println(dp[K]);
    }
}