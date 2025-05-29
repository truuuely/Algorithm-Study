import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> operator = new Stack<>();

        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            }
            else {
                if (c == '(') {
                    operator.push(c);
                } else if (c == ')') {
                    while (!operator.isEmpty()) {
                        Character pop = operator.pop();
                        if (pop == '(') {
                            break;
                        }
                        sb.append(pop);
                    }

                } else {
                    while (!operator.isEmpty() && getPriority(c) <= getPriority(operator.peek())) {
                        sb.append(operator.pop());
                    }
                    operator.push(c);
                }
            }
        }

        while (!operator.isEmpty()) {
            sb.append(operator.pop());
        }

        System.out.println(sb);
    }

    private static int getPriority(char c) {
        // 스택에 '('가 들어있을 때는 ')'를 만났을 때만 pop 해야 하므로 우선순위를 낮게 설정
        int priority = 0; // 괄호
        if (c == '+' || c == '-') {
            priority = 1;
        }
        else if (c == '*' || c == '/') {
            priority = 2;
        }

        return priority;
    }
}
