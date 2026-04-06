import java.util.*;

class Solution {
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
    char[][] map;
    int N, M;

    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();

        map = new char[N + 2][M + 2];
        for (int i = 0; i < N + 2; i++) {
            Arrays.fill(map[i], '.');
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        for (String req : requests) {
            char target = req.charAt(0);
            if (req.length() == 2) {
                for (int r = 1; r <= N; r++) {
                    for (int c = 1; c <= M; c++) {
                        if (map[r][c] == target) {
                            map[r][c] = '.';
                        }
                    }
                }
            } else {
                boolean[][] isExternal = findExternal();
                List<int[]> toRemove = new ArrayList<>();

                for (int r = 1; r <= N; r++) {
                    for (int c = 1; c <= M; c++) {
                        if (map[r][c] == target) {
                            for (int d = 0; d < 4; d++) {
                                if (isExternal[r + dr[d]][c + dc[d]]) {
                                    toRemove.add(new int[]{r, c});
                                    break;
                                }
                            }
                        }
                    }
                }
                for (int[] pos : toRemove) {
                    map[pos[0]][pos[1]] = '.';
                }
            }
        }

        // 남은 타일 개수 세기
        int answer = 0;
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                if (map[r][c] != '.') answer++;
            }
        }
        return answer;
    }

    boolean[][] findExternal() {
        boolean[][] visited = new boolean[N + 2][M + 2];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (nr >= 0 && nr < N + 2 && nc >= 0 && nc < M + 2) {
                    if (!visited[nr][nc] && map[nr][nc] == '.') {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return visited;
    }
}