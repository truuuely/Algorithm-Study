import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr = {1, 2, 3};
    static int n;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());

            dfs(0);

            sb.append(cnt).append('\n');
            cnt = 0;
        }

        System.out.println(sb);
    }

    private static void dfs(int sum) {
        // 종료 조건: sum >= n 이면
        if (sum >= n) {
            if (sum == n) {
                cnt += 1;
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            dfs(sum + arr[i]); // 1부터 3까지 더한다.
        }
    }


}
