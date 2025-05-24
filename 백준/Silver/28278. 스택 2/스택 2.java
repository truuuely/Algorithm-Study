import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MyStack stack = new MyStack();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
             switch (order) {
                case 1:
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    System.out.println(stack.pop());
                    break;
                case 3:
                    System.out.println(stack.size());
                    break;
                case 4:
                    System.out.println(stack.isEmpty());
                    break;
                case 5:
                    System.out.println(stack.peek());
                    break;
            }
        }
    }

}
class MyStack {
    private List<Integer> stack;

    public MyStack() {
        stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.remove(stack.size() - 1);
    }

    public int size() {
        return stack.size();
    }

    public int isEmpty() {
        return stack.isEmpty() ? 1 : 0;
    }

    public int peek() {
        return stack.isEmpty() ? -1 : stack.get(stack.size() - 1);
    }
}
