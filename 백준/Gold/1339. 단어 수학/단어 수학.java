import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // (1 ≤ N ≤ 10)
        String[] strArr = new String[N];
        for (int i = 0; i < N; i++) {
            strArr[i] = br.readLine();
        }

        Map<Character, Integer> map = new HashMap<>();
        for (String str : strArr) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + (int) Math.pow(10, str.length() - 1 - i));
            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.addAll(map.values());

        int sum = 0;
        int num = 9;
        while (!priorityQueue.isEmpty()) {
            sum += priorityQueue.poll() * num--;
        }

        System.out.println(sum);
    }
}
