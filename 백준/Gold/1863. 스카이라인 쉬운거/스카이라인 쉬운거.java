import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int y = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                stack.push(y);
            } else {
                while (!stack.isEmpty()) {
                    int peek = stack.peek();

                    if (peek > y) {
                        stack.pop();
                        cnt++;
                    } else if (peek == y) {
                        stack.pop();
                    } else {
                        break;
                    }
                }

                if (y == 0) {
                    continue;
                }
                stack.push(y);
            }
        }

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (pop > 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
