import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int[] arr;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 1 ≤ N ≤ 20
        S = Integer.parseInt(st.nextToken()); // |S| ≤ 1,000,000

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);

        System.out.println(S == 0 ? cnt - 1 : cnt);
    }

    // 최대 2의 20승.. -> 백만..
    public static void backtracking(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                cnt += 1;
            }
            
            return;
        }

        backtracking(index + 1, sum + arr[index]); // 현재 수 포함
        backtracking(index + 1, sum); //
    }
}
