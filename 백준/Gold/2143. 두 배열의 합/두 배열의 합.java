import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine()); // 1,000 이하
        int[] aSum = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            aSum[i] = aSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine()); // 1,000 이하
        int[] bSum = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            bSum[i] = bSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        // 부배열을 더해서 t가 되는 모든 경우의 수를 구해라
        // aSum[j]-aSum[i-1] + bSum[k] - bSum[l-1] = t 가 되는 경우의 수
        // i >= 1 , l >= 1
        Map<Integer, Integer> map = new HashMap<>(); // A 부배열의 합들 개수
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int itoj = aSum[j] - aSum[i - 1]; // Ai + ... + Aj

                if (map.containsKey(itoj)) {
                    map.put(itoj, map.get(itoj) + 1);
                }
                else {
                    map.put(itoj, 1);
                }
            }
        }

        long ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                int itoj = bSum[j] - bSum[i - 1]; // Bi + ... + Bj

                // A 부배열 합 + B 부배열 합 = T
                // 즉, T - B 부배열의 합 = A 부배열의 합
                if (map.containsKey(t - itoj)) {
                    ans += map.get(t - itoj);
                }
            }
        }

        System.out.println(ans);
    }
}