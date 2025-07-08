import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 10만
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (o1, o2) -> Math.abs(o1) == Math.abs(o2) ? o1 - o2 : Math.abs(o1) - Math.abs(o2));

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                int ans = 0;

                if (!minHeap.isEmpty()) {
                    ans = minHeap.poll();
                }

                sb.append(ans).append('\n');
            } else {
                minHeap.add(x);
            }
        }

        System.out.println(sb);
    }
}
