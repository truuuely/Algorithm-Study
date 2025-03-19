import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 시험 과목 개수 n 입력
        // n 개의 점수 입력받아 int[n] 배열에 저장하기
        // 저장 중에 최댓값 m 놓기
        // 새로운 평균 (원점수 / m * 100) 계산하기

        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n];

        int max = -1;
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());

            sum += scores[i];
            if (max < scores[i]) {
                max = scores[i];
            }
        }

        float ans = (float) sum * 100 / max / n;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}