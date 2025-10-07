import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] target;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String initialString = br.readLine();
        String targetString = br.readLine();

        // 목표 상태를 int 배열로 변환
        target = new int[N];
        for (int i = 0; i < N; i++) {
            target[i] = targetString.charAt(i) - '0';
        }

        // --- Case 1: 첫 번째 스위치를 누르지 않는 경우 ---
        int[] case1Bulbs = new int[N];
        for (int i = 0; i < N; i++) {
            case1Bulbs[i] = initialString.charAt(i) - '0';
        }
        int res1 = solve(case1Bulbs, 0);


        // --- Case 2: 첫 번째 스위치를 누르는 경우 ---
        int[] case2Bulbs = new int[N];
        for (int i = 0; i < N; i++) {
            case2Bulbs[i] = initialString.charAt(i) - '0';
        }
        // 첫 번째 스위치를 누르고 시작
        pressSwitch(case2Bulbs, 0);
        int res2 = solve(case2Bulbs, 1);


        // --- 결과 판정 ---
        // 두 경우 모두 목표 달성에 실패한 경우
        if (res1 == INF && res2 == INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(res1, res2));
        }
    }

    /**
     * Greedy 로직을 수행하여 최소 스위치 횟수를 반환하는 함수
     * @param bulbs 현재 전구 상태 배열
     * @param pressCount 초기 스위치 누름 횟수 (0 또는 1)
     * @return 목표 달성 시 총 스위치 횟수, 실패 시 INF
     */
    public static int solve(int[] bulbs, int pressCount) {
        // i-1번째 전구의 상태를 보고 i번째 스위치를 누를지 결정
        for (int i = 1; i < N; i++) {
            // i-1번째 전구가 목표 상태와 다르면, i번째 스위치를 눌러야만 함
            if (bulbs[i - 1] != target[i - 1]) {
                pressSwitch(bulbs, i);
                pressCount++;
            }
        }

        // 마지막 전구가 목표 상태와 같은지 최종 확인
        if (bulbs[N - 1] == target[N - 1]) {
            return pressCount;
        } else {
            return INF;
        }
    }

    /**
     * index 위치의 스위치를 누르는 함수
     * @param bulbs 전구 상태 배열
     * @param index 누를 스위치의 인덱스
     */
    public static void pressSwitch(int[] bulbs, int index) {
        // i-1, i, i+1 위치의 전구 상태를 변경 (범위 체크 포함)
        for (int i = index - 1; i <= index + 1; i++) {
            if (i >= 0 && i < N) {
                bulbs[i] = 1 - bulbs[i]; // 0 -> 1, 1 -> 0
            }
        }
    }
}

