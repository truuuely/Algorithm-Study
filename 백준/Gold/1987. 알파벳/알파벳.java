import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int R; // 1 <= R,C <= 20
    static int C;
    static char[][] board;
    static Set<Character> set = new HashSet<>();
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 1 <= R,C <= 20
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        backtracking(0, 0);

        System.out.println(max);
    }

    private static void backtracking(int row, int col) {
        if (row < 0 || row >= R || col < 0 || col >= C
                || set.contains(board[row][col])) {

            max = Math.max(max, set.size());
            return;
        }

        set.add(board[row][col]);

        // 상하좌우 확인
        backtracking(row - 1, col);
        backtracking(row + 1, col);
        backtracking(row, col - 1);
        backtracking(row, col + 1);

        set.remove(board[row][col]);
    }
}
