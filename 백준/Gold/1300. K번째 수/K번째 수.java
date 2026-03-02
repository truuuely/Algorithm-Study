import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine()); // N x N 행렬
        long K = Long.parseLong(br.readLine()); // K번째 수

        // 이분 탐색 범위 설정
        long low = 1;
        long high = K;
        long ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (count >= K) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }
}