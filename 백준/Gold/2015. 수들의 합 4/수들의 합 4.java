import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 최대 20만
        int K = Integer.parseInt(st.nextToken()); // |K| <= 20억
        long[] arr = new long[N+1]; // 누적합
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i-1] + Long.parseLong(st.nextToken());
        }

        long answer = 0l;
        Map<Long, Long> cnt = new HashMap<>(); // 값 카운트
        cnt.put(0l, 1l);
        for (int i = 1; i <= N; i++) {
            answer += cnt.getOrDefault(arr[i]-K, 0l); // 조건 만족하는 구간 수 추가
            cnt.put(arr[i], cnt.getOrDefault(arr[i], 0l) + 1); // 현재 누적합 등장 횟수 기록
        }
        System.out.println(answer);
    }

}