import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Stack<Character> st = new Stack<>();
            char[] ps = br.readLine().toCharArray();

            try {
                for (char c : ps) {
                    if (c == '(') {
                        st.push(c);
                    } else {
                        st.pop();
                    }
                }

                if (st.isEmpty()) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            } catch (EmptyStackException e) { // 스택에 아무것도 없는데 닫는 괄호가 나오면 NO
                System.out.println("NO");
            }
        }

    }
}
