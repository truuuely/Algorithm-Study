import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {
    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, 1, -1};
    private boolean[][] visited;
    private int N, M;

    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;

        visited = new boolean[N][M];
        int[] result = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    int amount = 0;
                    Set<Integer> columns = new HashSet<>(); // 어느 열을 지나가는지

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        amount += 1;
                        columns.add(cur[1]);

                        for (int k = 0; k < dr.length; k++) {
                            int nr = cur[0] + dr[k];
                            int nc = cur[1] + dc[k];

                            if (valid(nr, nc) && land[nr][nc] == 1 && !visited[nr][nc]) {
                                visited[nr][nc] = true;
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }

                    for (Integer column : columns) {
                        result[column] += amount;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int res : result) {
            answer = Math.max(res, answer);
        }

        return answer;
    }

    private boolean valid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}