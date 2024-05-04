
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] baskets = new int[n + 1];

        for (int i = 1; i < baskets.length; i++) {
            baskets[i] = i;
        }

        for (int a = 0; a < m; a++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

             int tmp = baskets[i];
             baskets[i] = baskets[j];
             baskets[j] = tmp;
        }
        br.close();

        for (int i = 1; i < baskets.length; i++) {
            bw.write(baskets[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
