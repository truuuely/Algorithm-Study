import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<String> stack = new Stack<>();
            while (st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }

            sb.append("Case #").append(i + 1).append(":");
            while (!stack.empty()) {
                sb.append(" ").append(stack.pop());
            }

            System.out.println(sb);
            sb.setLength(0);
        }
    }
}