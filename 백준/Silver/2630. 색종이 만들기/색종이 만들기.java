import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int white;
    static int blue;

    public static void main(String[] args) throws IOException {
        /** 첫째 줄에는 전체 종이의 한 변의 길이 N이 주어져 있다.
         * N은 2, 4, 8, 16, 32, 64, 128 중 하나이다.
         * 색종이의 각 가로줄의 정사각형칸들의 색이 윗줄부터 차례로 둘째 줄부터 마지막 줄까지 주어진다.
         * 하얀색으로 칠해진 칸은 0, 파란색으로 칠해진 칸은 1로 주어지며, 각 숫자 사이에는 빈칸이 하나씩 있다.

         출력
         첫째 줄에는 잘라진 햐얀색 색종이의 개수를 출력하고, 둘째 줄에는 파란색 색종이의 개수를 출력한다.*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide(int startRow, int startColumn, int size) {
        int whiteCnt = 0;

        for (int i = startRow; i < startRow + size; i++) {
            for (int j = startColumn; j < startColumn + size; j++) {
                if (paper[i][j] == 0) {
                    whiteCnt += 1;
                }
            }
        }

        if (whiteCnt == size * size) {
            white += 1;
            return;
        } else if (whiteCnt == 0) {
            blue += 1;
            return;
        }

        divide(startRow, startColumn, size / 2);
        divide(startRow, startColumn + size / 2, size / 2);
        divide(startRow + size / 2, startColumn, size / 2);
        divide(startRow + size / 2, startColumn + size / 2, size / 2);
    }
}