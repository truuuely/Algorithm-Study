import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 최대 50만 -> 시간복잡도 최대 O(nlogn) 이어야 함
        int[] tops = new int[N + 1]; // 인덱스 1부터
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        int[] receiver = new int[N + 1]; // 수신탑 인덱스
        Stack<Integer> stack = new Stack<>(); // '수신탑을 구해야 하는 탑'의 인덱스
        for (int i = N; i > 0; i--) {
            stack.push(i);
            // 탑의 높이는 모두 다르다고 했으므로 같을 때는 고려하지 않음
            if (tops[i - 1] > tops[stack.peek()]) { // 스택에 맨 위에 있던 탑의 수신탑은 i-1 번째
                while (!stack.isEmpty() && tops[i-1] > tops[stack.peek()]) {
                    receiver[stack.pop()] = i - 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(receiver[i]).append(' ');
        }
        System.out.println(sb);
    }
}
