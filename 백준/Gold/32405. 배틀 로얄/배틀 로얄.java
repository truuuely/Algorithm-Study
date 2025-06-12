import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 플레이어 수
        int[] attacks = new int[n + 1]; // 공격력 (1-indexed)
        int[] healths = new int[n + 1]; // 체력 (1-indexed)

        for (int i = 1; i <= n; i++) {
            attacks[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            healths[i] = sc.nextInt();
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            int attacksSum = 0;
            int qLen = q.size();
            List<Integer> survivors = new ArrayList<>();

            // 1단계: 살아남을 사람 선택 및 총 공격력 계산
            for (int i = 0; i < qLen; i++) {
                int player = q.poll();
                if (healths[player] - attacksSum > 0) {
                    attacksSum += attacks[player];
                    survivors.add(player);
                }
            }

            // 2단계: 피해 입히기
            for (int player : survivors) {
                healths[player] -= (attacksSum - attacks[player]);
                if (healths[player] > 0) {
                    q.add(player);
                }
            }
        }

        // 최종 생존자 출력
        System.out.println(q.peek());
    }
}