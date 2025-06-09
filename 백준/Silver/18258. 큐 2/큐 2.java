import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        MyQueue queue = new MyQueue();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(queue.pop()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.empty()).append('\n');
                    break;
                case "front":
                    sb.append(queue.front()).append('\n');
                    break;
                case "back":
                    sb.append(queue.back()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}

class MyQueue {
    private int[] list;
    private int front;
    private int back;

    public MyQueue() {
        this.list = new int[2000000];
    }

    public void push(int x) {
        list[back++] = x;
    }

    public int pop() {
        if (front == back) {
            return -1;
        }

        return list[front++];
    }

    public int size() {
        return back - front;
    }

    public int empty() {
        return back > front ? 0 : 1;
    }

    public int front() {
        if (back == front) {
            return -1;
        }

        return list[front];
    }

    public int back() {
        if (back == front) {
            return -1;
        }

        return list[back - 1];
    }
}
