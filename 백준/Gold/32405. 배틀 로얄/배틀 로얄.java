import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] attacks = new int[n + 1];
        int[] healths = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            attacks[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            healths[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            int attacksSum = 0;
            int qLen = q.size();
            int[] temp = new int[qLen];
            int idx = 0;

            // 1단계: 살아남을 사람 결정하고 공격력 누적
            for (int i = 0; i < qLen; i++) {
                int player = q.poll();
                if (healths[player] - attacksSum > 0) {
                    attacksSum += attacks[player];
                    temp[idx++] = player;
                }
            }

            // 2단계: 피해 적용 및 생존자만 큐에 다시 추가
            for (int i = 0; i < idx; i++) {
                int player = temp[i];
                healths[player] -= (attacksSum - attacks[player]);
                if (healths[player] > 0) {
                    q.add(player);
                }
            }
        }

        System.out.println(q.peek());
    }
}