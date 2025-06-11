import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken());
            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                queue.add(new int[] {j, Integer.parseInt(st.nextToken())}); // 인덱스, 중요도
            }

            int cnt = 0;
            while (!queue.isEmpty()) {
                int idx = queue.peek()[0];
                int priority = queue.peek()[1];

                boolean isMaxPriority = true;
                for (int j = 0; j < queue.size(); j++) {
                    if (priority < queue.get(j)[1]) {
                        isMaxPriority = false;
                        break;
                    }
                }

                if (isMaxPriority) {
                    queue.pop();
                    cnt++;
                    if (idx == M) {
                        break;
                    }
                } else {
                    queue.add(queue.pop());
                }
            }

            System.out.println(cnt);
        }
    }
}