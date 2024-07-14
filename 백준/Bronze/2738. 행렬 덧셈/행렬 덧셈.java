import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        ArrayList<String> eachLine = new ArrayList<>();
        for (int i = 0; i < 2 * n; i++) {
            String s = br.readLine();
            eachLine.add(s);
        }

        for (int i = 0; i < n; i++) {
            String[] row1 = eachLine.get(i).split(" ");
            String[] row2 = eachLine.get(i + n).split(" ");

            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(row1[j]) + Integer.parseInt(row2[j]);
                sb.append(num + " ");
            }
            sb.append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}