import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long[][][] dp = new long[N + 1][N + 1][N + 1];

        dp[1][1][1] = 1;
        for (int h = 2; h <= N; h++) {
            dp[h][h][1] = dp[h][1][h] = 1;

            for (int l = 1; l <= L; l++) {
                for (int r = 1; r <= R; r++) {
                    dp[h][l][r] = (dp[h - 1][l - 1][r] + dp[h - 1][l][r - 1] + dp[h - 1][l][r] * (h - 2)) % MOD;
                }
            }
        }

        System.out.println(dp[N][L][R]);
    }
}
