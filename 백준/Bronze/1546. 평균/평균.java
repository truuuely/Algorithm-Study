import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = -1;
        int total = 0;
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            total += score[i];
            if (max < score[i]) {
                max = score[i];
            }
        }
        System.out.println(total * 100.0 / max / n);
    }
}