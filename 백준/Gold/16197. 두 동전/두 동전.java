import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int N, M;
    private static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][N + 1][M + 1];

        Queue<TwoCoins> q = new ArrayDeque<>();
        ArrayList<int[]> coins = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = line.charAt(j - 1);
                if (board[i][j] == 'o') {
                    coins.add(new int[]{i, j});
                }
            }
        }

        q.add(new TwoCoins(coins.get(0)[0], coins.get(0)[1], coins.get(1)[0], coins.get(1)[1], 0));
        visited[coins.get(0)[0]][coins.get(0)[1]][coins.get(1)[0]][coins.get(1)[1]] = true;

        while (!q.isEmpty()) {
            TwoCoins cur = q.poll();
            if (cur.moveCnt >= 10) {
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int nr1 = cur.r1 + dx[i];
                int nc1 = cur.c1 + dy[i];
                int nr2 = cur.r2 + dx[i];
                int nc2 = cur.c2 + dy[i];

                boolean drop1 = isDropped(nr1, nc1);
                boolean drop2 = isDropped(nr2, nc2);

                if (drop1 && drop2) {
                    continue;
                }

                if (drop1 || drop2) {
                    System.out.println(cur.moveCnt + 1);
                    return;
                }

                if (board[nr1][nc1] == '#') {
                    nr1 = cur.r1;
                    nc1 = cur.c1;
                }
                if (board[nr2][nc2] == '#') {
                    nr2 = cur.r2;
                    nc2 = cur.c2;
                }

                if (!visited[nr1][nc1][nr2][nc2]) {
                    visited[nr1][nc1][nr2][nc2] = true;
                    q.add(new TwoCoins(nr1, nc1, nr2, nc2, cur.moveCnt + 1));
                }
            }
        }

        System.out.println("-1");
    }

    private static boolean isDropped(int r, int c) {
        return r < 1 || r > N || c < 1 || c > M;
    }

    static class TwoCoins {
        int r1, c1, r2, c2;
        int moveCnt;

        public TwoCoins(int r1, int c1, int r2, int c2, int moveCnt) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.moveCnt = moveCnt;
        }
    }
}