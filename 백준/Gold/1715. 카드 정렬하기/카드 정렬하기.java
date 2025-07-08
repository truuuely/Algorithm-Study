import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 10만
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            minHeap.add(Integer.parseInt(br.readLine()));
        }

        int totalSum = 0;
        while (!minHeap.isEmpty()) {
            if (minHeap.size() < 2) {
                break;
            }

            int sum = minHeap.poll() + minHeap.poll();
            totalSum += sum;
            minHeap.add(sum);
        }

        System.out.println(totalSum);
    }
}
