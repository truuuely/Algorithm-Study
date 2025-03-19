import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수의 개수 n, 합을 구해야 하는 횟수 m
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // n개의 수를 배열에 저장하면서, 합 배열 생성
        int[] arr = new int[n + 1];
        int[] sumArr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i == 1) {
                sumArr[i] = arr[i];
                continue;
            }
            sumArr[i] = sumArr[i - 1] + arr[i];
        }

        // 합 배열에서 구간 합 출력
        for (int itr = 0; itr < m; itr++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(sumArr[j] - sumArr[i - 1]);
            
        }
    }
}