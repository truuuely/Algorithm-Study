import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // (1 ≤ N ≤ 1,000)
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken(); // 10억 미만
        }

        Arrays.sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        if (arr[0].startsWith("0")) {
            System.out.println(0);
        } else {
            System.out.println(String.join("", arr));
        }
    }
}
