import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] dp; // 최소 길이 dp

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 1 ~ 12
        int D = Integer.parseInt(st.nextToken()); // 1 ~ 10,000
        dp = new int[D + 1];
        List<Shortcut> shortcuts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            Shortcut shortcut = new Shortcut(start, end, length);
            shortcuts.add(shortcut);
        }

        shortcuts.sort((o1, o2) -> o1.start - o2.start);

        for (int i = 1; i <= D; i++) {
            dp[i] = i; // 고속도로만 탈 때의 거리
        }

        // 그냥 이동 vs 지름길 이동
        for (int i = 1; i <= D; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1); // 기본적인 이동 업뎃

            for (Shortcut s : shortcuts) {
                if (s.end == i) {
                    dp[i] = Math.min(dp[i], dp[s.start] + s.length);
                }
            }
        }

        System.out.println(dp[D]);
    }

    static class Shortcut {
        int start, end;
        int length;

        public Shortcut(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }
}