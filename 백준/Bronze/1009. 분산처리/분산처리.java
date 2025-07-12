import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); /// 1 <= a < 100
            int b = Integer.parseInt(st.nextToken()); /// 1 <= b < 1,000,000

            int ans = 1;
            for (int j = 1; j <= b; j++) {
                ans = ans * a % 10;
            }

            sb.append(ans == 0 ? 10 : ans).append('\n');
        }

        System.out.println(sb);
    }
}