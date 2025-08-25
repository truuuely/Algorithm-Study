import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static boolean[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); // 가로길이
            N = Integer.parseInt(st.nextToken()); // 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 배추 개수

            arr = new boolean[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int Y = Integer.parseInt(st.nextToken());
                int X = Integer.parseInt(st.nextToken());

                arr[X][Y] = true;
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] && !visited[i][j]) {
                        dfs(i, j);
                        cnt += 1;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void dfs(int x, int y) {
        if (!valid(x, y) || !arr[x][y] || visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);
    }

    private static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}