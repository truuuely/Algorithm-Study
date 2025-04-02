import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 최대 15,000
        int m = Integer.parseInt(br.readLine()); // 합 M(1 ≤ M ≤ 10,000,000)
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // n*n -> 최대 약 2억번 => 2초 넘음
        // 투 포인터 사용 필요
        int startIndex = 0;
        int endIndex = 1;
        int cnt = 0;
        while (startIndex < n - 1) {
            // count sum
            int sum = arr[startIndex] + arr[endIndex];
            if (sum == m) {
                cnt++;
            }

            if (endIndex == n - 1) { // 마지막 인덱스면
                startIndex++;
                endIndex = startIndex + 1;
            } else {
                endIndex++;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();
    }

}