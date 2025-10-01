import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] num = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (K > 0 && !stack.isEmpty() && stack.peek() < num[i]) {
                stack.pop();
                K--;
            }
            stack.push(num[i]);
        }

        while (K > 0) {
            stack.pop();
            K--;
        }

        StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);
        System.out.println(sb);
    }
}