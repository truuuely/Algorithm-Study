import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 천만 이하
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        int startIndex = 1;
        int endIndex = 1;
        int sum = 0;
        int cnt = 1; // n 포함
        while (startIndex <= n / 2) {
            if (sum < n) {  // sum < n 이면 -> end를 한 칸씩 늘림, sum += arr[end]
                sum += arr[endIndex++];
            } else if (sum == n) { // sum == n 이면 -> start를 한 칸씩 늘림
                cnt++;
                sum -= arr[startIndex++];
            } else { // sum > n이면 start를 한 칸씩 늘림
                sum -= arr[startIndex++];
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

}