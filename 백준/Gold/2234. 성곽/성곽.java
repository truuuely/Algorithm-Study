import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static int[][] visited;
    private static int[] dRow = {1, 0, -1, 0}; // 남, 동, 북, 서
    private static int[] dCol = {0, 1, 0, -1};
    private static int[] bitDir = {8, 4, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int roomCnt = 0;
        int[] roomSizes = new int[2501];

        // 방 개수, 방 크기
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    // bfs 탐색 => 방 넓이 반환
                    int roomSize = bfs(i, j, roomCnt + 1);
                    // 탐색 끝났으면 방 개수+1
                    roomCnt += 1;
                    roomSizes[roomCnt] = roomSize;
                }
            }
        }

        int canBeMaxArea = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int roomNum = visited[i][j];
                for (int k = 0; k < dRow.length; k++) {
                    int nRow = i + dRow[k];
                    int nCol = j + dCol[k];
                    if (valid(nRow, nCol) && roomNum != visited[nRow][nCol]) {
                        int adjacentRoomNum = visited[nRow][nCol];
                        canBeMaxArea = Math.max(canBeMaxArea, roomSizes[roomNum] + roomSizes[adjacentRoomNum]);
                    }
                }
            }
        }

        int maxArea = Arrays.stream(roomSizes).max().getAsInt();
        System.out.println(roomCnt);
        System.out.println(maxArea);
        System.out.println(canBeMaxArea);
    }

    // 1111 -> 남동북서
    private static int bfs(int r, int c, int roomNumber) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(r, c));
        visited[r][c] = roomNumber;

        int area = 0;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int curR = poll.row;
            int curC = poll.col;
            int bitmask = map[curR][curC];
            area += 1;

            for (int i = 0; i < bitDir.length; i++) {
                // 벽 있는 곳 & 남/동/북/서
                if ((bitmask & bitDir[i]) == 0) {
                    int nRow = curR + dRow[i];
                    int nCol = curC + dCol[i];
                    if (valid(nRow, nCol) && visited[nRow][nCol] == 0) {
                        visited[nRow][nCol] = roomNumber;
                        queue.add(new Point(nRow, nCol));
                    }
                }
            }
        }

        return area;
    }

    private static boolean valid(int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N;
    }

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}