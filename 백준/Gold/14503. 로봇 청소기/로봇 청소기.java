import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] drBack = {1, 0, -1, 0};
    public static int[] dcBack = {0, -1, 0, 1};
    public static int[] drForward = {-1, 0, 1, 0};
    public static int[] dcForward = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 0: 북, 1: 동, 2: 남, 3: 서

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
            }
        }

        int cnt = 0;
        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                cnt += 1;
            }

            if (map[r - 1][c] != 0 && map[r][c + 1] != 0 && map[r + 1][c] != 0 && map[r][c - 1] != 0) {
                // d == 0 -> r = r + 1, c = c
                // d == 1 -> r = r    , c = c - 1
                // d == 2 -> r = r - 1, c = c
                // d == 3 -> r = r    , c = c + 1
                r += drBack[d];
                c += dcBack[d];
                if (map[r][c] == 1) {
                    break;
                }
            } else {
                // 1이면 0, 2면 1, 3이면 2, 0이면 3
                // 반시계 회전 d = (d - 1) % 3
                d = d == 0 ? 3 : d - 1;

                // d = 0 -> r = r - 1, c = c
                // d = 1 -> r = r    , c = c + 1
                // d = 2 -> r = r + 1, c = c
                // d = 3 -> r = r    , c = c - 1
                if (map[r + drForward[d]][c + dcForward[d]] == 0) {
                    r += drForward[d];
                    c += dcForward[d];
                }
            }
        }

        System.out.println(cnt);
    }
}