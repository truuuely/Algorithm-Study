import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int row, col;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dRow = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static int[] dCol = {0, 0, -1, 1, -1, 1, -1, 1};

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            if (col == 0 && row == 0) {
                break;
            }

            map = new int[row][col];
            visited = new boolean[row][col];

            List<Point> islands = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        islands.add(new Point(i, j));
                    }
                }
            }

            int ans = 0;
            for (Point p : islands) {
                int r = p.row;
                int c = p.col;
                if (!visited[r][c]) {
                    visited[r][c] = true;
                    dfs(r, c);
                    ans += 1;
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }

    private static void dfs(int r, int c) {
        for (int i = 0; i < dRow.length; i++) {
            int nrow = r + dRow[i];
            int ncol = c + dCol[i];

            if (valid(nrow, ncol) && !visited[nrow][ncol] && map[nrow][ncol] == 1){
                visited[nrow][ncol] = true;
                dfs(nrow, ncol);
            }
        }
    }

    private static boolean valid(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }
}