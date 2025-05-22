import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken()); // 원생의 수 (최소 1명, 최대 30만)
        int k =  Integer.parseInt(st.nextToken()); // 나누려고 하는 조 개수 (최소 1개, 최대 n개)
        int[] height = new int[n]; // 정렬 되어있는 키 (최대 키는 10억)
        int[] diff = new int[n - 1]; // 키 차이
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());

            if (i > 0) {
                diff[i - 1] = height[i] - height[i - 1];
            }
        }

        // 1 3 5 6 10
        //  2 2 1 4   -> n-1개의 키 차이 중 큰 순으로 k-1개는 제외, 나머지는 더함 (가장 큰 k-1개를 기준으로 나눔)
        // 나눠야 하는 부분은 키 차이가 많이 나는 애들 사이 => 해당 비용은 제외되기 때문
        Arrays.sort(diff);
        int ans = 0;
        for (int i = 0; i < n - k; i++) {
            ans += diff[i];
        }

        System.out.println(ans);
    }
}
