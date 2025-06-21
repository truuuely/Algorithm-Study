import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 최대 10만
        int K = Integer.parseInt(st.nextToken()); // 연속 K의 합

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int[] temperatures = new int[N];
        for (int i = 0; i < N; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
            if (i < K) {
                sum += temperatures[i];
            }
        }

        int max = sum;
        for (int i = K; i < N; i++) {
            sum = sum + temperatures[i] - temperatures[i - K];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}