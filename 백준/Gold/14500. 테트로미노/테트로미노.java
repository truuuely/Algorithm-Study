import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = 0;
    static int N;
    static int M;
    static int[][] board;
    static boolean[][] isVisited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M]; // 1-based
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /**
         * 정사각형 4개를 이어붙인 폴리노미오를 테트로미노라고 한다.
         * 이 테트로미노 **하나**를 적절히 놓아서 테트로미노가 놓인 칸에 쓰인 수들의 합 중 최대를 출력
         * 테트로미노를 회전, 대칭 시켜도 된다
         */

        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                backtracking(i, j, 0, 0);
            }
        }

        System.out.println(max);
    }

    private static void backtracking(int row, int col, int sqrCnt, int sum) {
        // 정사각형 개수가 4개가 되었으면
        // 각 자리 총합인 sum 을 max와 비교해서 저장하고 종료
        if (sqrCnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        if (sqrCnt == 3) {
            if (isValidRange(row - 1, col) && isVisited[row - 1][col] && isValidRange(row - 2, col) && isVisited[row - 2][col]) {
                if (isValidRange(row - 1, col - 1)) {
                    max = Math.max(max, sum + board[row - 1][col - 1]);
                }

                if (isValidRange(row - 1, col + 1)) {
                    max = Math.max(max, sum + board[row - 1][col + 1]);
                }
                return;
            }

            if (isValidRange(row, col - 1) && isVisited[row][col - 1] && isValidRange(row, col - 2) && isVisited[row][col - 2]) {
                if (isValidRange(row - 1, col - 1)) {
                    max = Math.max(max, sum + board[row - 1][col - 1]);
                }

                if (isValidRange(row + 1, col - 1)) {
                    max = Math.max(max, sum + board[row + 1][col - 1]);
                }
                return;
            }
        }

        // 한 칸씩 이동하면서 도형 완성
        for (int i = 0; i < 4; i++) {
            int nRow = row + dx[i];
            int nCol = col + dy[i];

            if (isValidRange(nRow, nCol) && !isVisited[nRow][nCol]) {
                isVisited[nRow][nCol] = true;
                backtracking(nRow, nCol, sqrCnt + 1, sum + board[nRow][nCol]);
                isVisited[nRow][nCol] = false;
            }
        }
    }

    private static boolean isValidRange(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}
