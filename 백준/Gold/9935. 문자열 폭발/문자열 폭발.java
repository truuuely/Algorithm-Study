import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 2초 (2억번 내)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); // s.length <= 1,000,000
        String bomb = br.readLine();

        Stack<Character> stack = getCharacters(s, bomb);

        if (stack.isEmpty()) {
            System.out.println("FRULA");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    private static Stack<Character> getCharacters(String s, String bomb) {
        Stack<Character> stack = new Stack<>();
        int L = bomb.length();

        for (char c : s.toCharArray()) {  // O(n)
            stack.push(c);
            if (stack.size() >= L) {
                // 스택의 맨 위부터 폭발 문자열 개수만큼 확인
                boolean isBomb = true;
                for (int j = 0; j < L; j++) { // m <= 36
                    if (bomb.charAt(j) != stack.get(stack.size() + j - L)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    for (int j = 0; j < L; j++) {
                        stack.pop();
                    }
                }
            }
        }
        return stack;
    }
}