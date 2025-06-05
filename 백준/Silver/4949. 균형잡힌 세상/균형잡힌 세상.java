import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        while (!(line = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean valid = true;
            for (char c : line.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        valid = false;
                        break;
                    }
                } else if (c == '[') {
                    stack.push(c);
                } else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                sb.append("no").append('\n');
            } else {
                if (stack.isEmpty()) {
                    sb.append("yes").append('\n');
                } else {
                    sb.append("no").append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}
