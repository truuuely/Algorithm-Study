import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine()); // 자연수 N 입력
            dfs(1, 1, 1, 0, "1"); // DFS 시작 (첫 번째 숫자는 항상 1)
            sb.append("\n"); // 테스트 케이스 구분
        }

        System.out.println(sb.toString()); // 결과 출력
    }

    /**
     * DFS (Depth-First Search) 를 통해 모든 가능한 수식을 생성하고, 결과가 0인 수식을 StringBuilder 에 저장
     * @param now 현재 숫자
     * @param num 이전까지 계산된 숫자
     * @param sign 이전 숫자의 부호 (1: +, -1: -)
     * @param sum  현재까지의 합
     * @param str  현재까지 만들어진 수식 문자열
     */
    private static void dfs(int now, int num, int sign, int sum, String str) {
        if (now == N) { // 마지막 숫자에 도달했을 경우
            sum = sum + (num * sign); // 마지막 숫자까지 계산
            if (sum == 0) { // 합이 0일 경우
                sb.append(str).append("\n"); // 결과 문자열에 추가
            }
            return; // 재귀 종료
        }

        // 1. 공백을 추가하는 경우: 다음 숫자를 현재 숫자에 이어붙임
        dfs(now + 1, num * 10 + (now + 1), sign, sum, str + " " + (now + 1));

        // 2. "+" 를 추가하는 경우: 다음 숫자를 더함
        dfs(now + 1, now + 1, 1, sum + (num * sign), str + "+" + (now + 1));

        // 3. "-" 를 추가하는 경우: 다음 숫자를 뺌
        dfs(now + 1, now + 1, -1, sum + (num * sign), str + "-" + (now + 1));
    }
}