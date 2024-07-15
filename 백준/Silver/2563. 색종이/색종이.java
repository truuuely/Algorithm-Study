import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] paper = new boolean[100][100];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    paper[j][k] = true;
                }
            }
        }

        int area = 0;
        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < paper[i].length; j++) {
                if (paper[i][j]) {
                    area++;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(area));
        bw.flush();
        bw.close();
    }
}