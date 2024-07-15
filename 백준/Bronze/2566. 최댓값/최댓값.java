import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1;
        int row = -1, column = -1;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n > max) {
                    max = n;
                    row = i;
                    column = j;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(max + "\n" + (row + 1) + " " + (column + 1));
        bw.flush();
        bw.close();
    }
}