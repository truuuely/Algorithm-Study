import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int sharkR, sharkC, sharkSize, sharkEatCount;
    static int totalTime;

    // 상, 하, 좌, 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    // 먹이 후보 물고기를 저장할 클래스
    static class Fish implements Comparable<Fish> {
        int r, c, dist;

        Fish(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        // 우선순위 정렬 기준 (거리 -> 행 -> 열)
        @Override
        public int compareTo(Fish other) {
            if (this.dist != other.dist) {
                return this.dist - other.dist; // 1. 거리 (오름차순)
            }
            if (this.r != other.r) {
                return this.r - other.r; // 2. 행 (오름차순 - 위쪽)
            }
            return this.c - other.c; // 3. 열 (오름차순 - 왼쪽)
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 맵 정보 입력 및 상어 초기 위치 확인
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkR = i;
                    sharkC = j;
                    map[i][j] = 0; // 상어 위치는 빈 칸으로
                }
            }
        }

        sharkSize = 2;
        sharkEatCount = 0;
        totalTime = 0;

        // 메인 시뮬레이션 루프
        while (true) {
            Fish target = findFish();

            // 먹을 물고기가 없으면 종료
            if (target == null) {
                break;
            }

            // 물고기를 먹고 상태 갱신
            totalTime += target.dist; // 이동 시간 추가
            sharkR = target.r;         // 상어 위치 이동
            sharkC = target.c;
            map[sharkR][sharkC] = 0;   // 물고기 제거
            sharkEatCount++;

            // 상어 성장
            if (sharkEatCount == sharkSize) {
                sharkSize++;
                sharkEatCount = 0;
            }
        }

        System.out.println(totalTime);
    }

    // BFS로 먹을 수 있는 물고기를 찾는 함수
    static Fish findFish() {
        int[][] dist = new int[N][N]; // 거리 및 방문 체크
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sharkR, sharkC});
        dist[sharkR][sharkC] = 0;

        List<Fish> candidates = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 1. 맵 범위 안인지 확인
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                // 2. 이미 방문했는지 확인
                if (dist[nr][nc] != -1) continue;
                // 3. 지나갈 수 있는지 확인 (상어 크기보다 작거나 같아야 함)
                if (map[nr][nc] > sharkSize) continue;

                // 이동 가능
                dist[nr][nc] = dist[r][c] + 1;
                q.add(new int[]{nr, nc});

                // 먹을 수 있는 물고기인지 확인
                if (map[nr][nc] > 0 && map[nr][nc] < sharkSize) {
                    candidates.add(new Fish(nr, nc, dist[nr][nc]));
                }
            }
        }

        // 먹이 후보가 없으면 null 반환
        if (candidates.isEmpty()) {
            return null;
        }

        // 우선순위에 따라 정렬
        Collections.sort(candidates);
        // 가장 우선순위가 높은(첫 번째) 물고기 반환
        return candidates.get(0);
    }
}