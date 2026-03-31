import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            backtracking(1, 1, sb, String.valueOf(i));
        }
        System.out.println(sb);
    }

    private static void backtracking(int start, int cnt, StringBuilder sb, String string) {
        if (cnt == M) {
            sb.append(string).append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            backtracking(i, cnt + 1, sb, string + " " + i);
        }
    }

}