import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) { // O(100)
            StringBuilder sb = new StringBuilder();
            String p = br.readLine(); // 뒤집기, 버리기 최대 100,000개
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();  // 0 <= 수의 개수 <= 100,000
            /// 배열에 들어가있는 정수 입력받기
            String[] split = br.readLine().replace("[", "").replace("]", "")
                    .split(",");

            for (int j = 0; j < n; j++) { // 배열 입력 받음. O(100,000)
                deque.offerLast(Integer.parseInt(split[j]));
            }

            boolean isReversed = false;
            for (int j = 0; j < p.length(); j++) { // 함수 수행 O(100,000)
                char func = p.charAt(j);
                if (func == 'R') {
                    // 배열 뒤집기 => 즉 인덱스를 거꾸로
                    isReversed = !isReversed;
                } else {
                    Integer deletedNum = isReversed ? deque.pollLast() : deque.pollFirst();

                    if (deletedNum == null) {
                        sb = new StringBuilder("error");
                        break;
                    }
                }
            }

            // 결과 출력
            if (sb.toString().equals("error")) {
                System.out.println(sb);
                continue;
            }

            sb.append("[");
            while (!deque.isEmpty()) { // 최대 100,000번
                if (isReversed) {
                    sb.append(deque.pollLast());
                } else {
                    sb.append(deque.pollFirst());
                }

                if (!deque.isEmpty()) {
                    sb.append(",");
                }
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}
