import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double dist = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
            double rSum = Math.pow(r1 + r2, 2);
            if (dist > rSum) {
                sb.append(0).append('\n');
            } else if (dist == rSum) {
                sb.append(1).append('\n');
            } else {
                if (dist == 0 && r1 == r2) {
                    // 동일
                    sb.append(-1).append('\n');
                } else if (Math.pow(r1 - r2, 2) == dist) {
                    // 내접
                    sb.append(1).append('\n');
                } else if (Math.pow(r1 - r2, 2) > dist) {
                    // 내부
                    sb.append(0).append('\n');
                } else {
                    // 2개
                    sb.append(2).append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}
