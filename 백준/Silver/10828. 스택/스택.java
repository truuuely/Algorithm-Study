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

        StringTokenizer st;
        MyStack stack = new MyStack();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (order.equals("pop")) {
                System.out.println(stack.pop());
            } else if (order.equals("size")) {
                System.out.println(stack.size());
            } else if (order.equals("empty")) {
                System.out.println(stack.empty());
            } else if (order.equals("top")) {
                System.out.println(stack.top());
            }
        }
    }
}

class MyStack {
    List<Integer> stack;

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

    public int empty() {
        return stack.isEmpty() ? 1 : 0;
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.get(stack.size() - 1);
    }
}