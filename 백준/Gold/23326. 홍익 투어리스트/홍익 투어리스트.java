import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 50만 이하의 자연수
        int Q = Integer.parseInt(st.nextToken()); // 10만 이하의 자연수

        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>(); // 명소 위치를 넣어놓는 트리셋
        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                treeSet.add(i);
            }
        }

        int position = 1; // 현재 위치
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    // i번째 구역 명소 반전
                    int idx = Integer.parseInt(st.nextToken());
                    if (treeSet.contains(idx)) {
                        treeSet.remove(idx);
                    } else {
                        treeSet.add(idx);
                    }
                    break;
                case 2:
                    // 시계방향으로 x만큼 이동 (x는 최대 10억)
                    int x = Integer.parseInt(st.nextToken()) % N;
                    position += x;
                    if (position > N) {
                        position %= N;
                    }
                    break;
                case 3:
                    // 명소로 이동 (최대 N-1번 이동) => O(log n)으로 찾아야 함
                    if (treeSet.isEmpty()) {
                        sb.append(-1).append('\n');
                        continue;
                    }

                    int goodPlace = treeSet.ceiling(position) != null ? treeSet.ceiling(position) : treeSet.first();
                    int moveCnt = goodPlace >= position ? goodPlace - position : goodPlace + N - position;
                    sb.append(moveCnt).append('\n');
            }
        }

        System.out.println(sb);
    }
}