import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Queue<String>> parrotWords = new ArrayList<>();
        for (int i = 0; i < N; i++) { // 100
            Queue<String> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) { // 최대 100개
                queue.add(st.nextToken());
            }
            parrotWords.add(queue);
        }

        String[] L = br.readLine().split(" "); // 받아적은 문장
        for (int i = 0; i < L.length; i++) { // 10000
            String word = L[i];
            boolean isContained = false;
            for (int j = 0; j < parrotWords.size(); j++) {
                Queue<String> queue = parrotWords.get(j);
                if (!queue.isEmpty() && word.equals(queue.peek())) {
                    queue.poll();
                    isContained = true;
                }
            }

            if (!isContained) {
                System.out.println("Impossible");
                return;
            }
        }

        boolean isPossible = true;
        for (Queue q : parrotWords) {
            if (!q.isEmpty()) {
                isPossible = false;
                break;
            }
        }

        System.out.println(isPossible ? "Possible" : "Impossible");
    }
}