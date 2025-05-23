import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1 <= N, M <= 100,000
 * - 이중 반복문을 통해 확인하는 건 불가능
 * - ArrayList의 contains()도 시간 복잡도가 O(n)이므로 불가능
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 10만
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>(); // 중복 상관없이 존재 여부만 알면 됨
        for (int i = 1; i <= n; i++) {
            int aNum = Integer.parseInt(st.nextToken());
            set.add(aNum);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int mNum = Integer.parseInt(st.nextToken());
            int ans = set.contains(mNum) ? 1 : 0;
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}