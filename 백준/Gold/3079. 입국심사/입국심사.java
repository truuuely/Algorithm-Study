import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// T초 안에 모든 심사대에서 최대 몇 명을 심사할 수 있는지
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 10만
        int M = Integer.parseInt(st.nextToken()); // 10억
        int[] time = new int[N];
        long low = 1, high = -1;
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, time[i]);
        }

        high *= M;
        long ans = 0;
        while (low <= high) {
            long mid = (low + high) / 2;

            long sum = 0; // mid 초 동안 처리 가능한 인원
            for (int i = 0; i < N; i++) {
                sum += mid / time[i];
                if (sum >= M) {
                    break;
                }
            }

            if (sum >= M) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }
}