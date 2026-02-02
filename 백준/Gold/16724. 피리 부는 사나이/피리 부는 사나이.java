import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1차원 배열로 유니온 파인드 관리 (0 ~ N*M - 1)
        parent = new int[N * M];
        for (int i = 0; i < N * M; i++) {
            parent[i] = i;
        }

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                int cur = r * M + c;
                int nr = r, nc = c;

                switch (map[r][c]) {
                    case 'U':
                        nr--;
                        break;
                    case 'D':
                        nr++;
                        break;
                    case 'L':
                        nc--;
                        break;
                    case 'R':
                        nc++;
                        break;
                }

                int next = nr * M + nc;
                // 현재 칸과 가야 할 칸을 유니온 파인드
                if (find(cur) != find(next)) {
                    union(cur, next);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N * M; i++) {
            if (parent[i] == i) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    static int find(int i) {
        if (parent[i] == i) {
            return i;
        }

        return parent[i] = find(parent[i]);
    }

    static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if (i != j) {
            parent[i] = j;
        }
    }
}