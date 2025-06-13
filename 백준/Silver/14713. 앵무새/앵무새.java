import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Queue<String>> parrotWords = new ArrayList<>();
        for (int i = 0; i < N; i++) { // 최대 100
            Queue<String> queue = new LinkedList<>(Arrays.asList(br.readLine().split(" ")));
            parrotWords.add(queue);
        }

        String[] L = br.readLine().split(" "); // 받아적은 문장
        for (String word : L) { // 최대 10000
            boolean isContained = false;
            for (Queue<String> queue : parrotWords) { // 최대 100
                if (!queue.isEmpty() && word.equals(queue.peek())) {
                    queue.poll();
                    isContained = true;
                    break;
                }
            }

            if (!isContained) {
                System.out.println("Impossible");
                return;
            }
        }

        for (Queue<String> q : parrotWords) {
            if (!q.isEmpty()) {
                System.out.println("Impossible");
                return;
            }
        }

        System.out.println("Possible");
    }
}