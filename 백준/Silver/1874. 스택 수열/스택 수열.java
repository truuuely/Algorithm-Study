import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); // 10만
        Stack<Integer> stack = new Stack<>();
        int stackedNum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (stack.empty()) {
                for (int j = stackedNum + 1; j <= num; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                stackedNum = num;
            }

            Integer top = stack.peek();
            if (top == num) {
                stack.pop();
                sb.append("-\n");
            } else if (top < num) {
                for (int j = stackedNum + 1; j <= num; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
                stackedNum = num;
            } else {
                sb.setLength(0);
                sb.append("NO");

                break;
            }

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}