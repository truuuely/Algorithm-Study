import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] board = new String[50];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int cnt = getSolution(i, j, board);
                min = cnt < min ? cnt : min;
            }

        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

    private static int getSolution(int startRow, int startCol, String[] board) {
        String[] blackBoard = {"BWBWBWBW", "WBWBWBWB"};
        int blackCnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i + startRow].charAt(j + startCol) != blackBoard[i % 2].charAt(j)) {
                    blackCnt++;
                }
            }
        }

        // 화이트 보드로 만들 때 칠하는 수 + 블랙 보드로 만들 때 칠하는 수 = 전체 보드 사이즈
        return blackCnt < 64 - blackCnt ? blackCnt : 64 - blackCnt;
    }

}