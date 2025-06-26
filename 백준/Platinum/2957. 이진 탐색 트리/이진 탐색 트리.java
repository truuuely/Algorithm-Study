import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static long cnt; // 트리가 편향된 경우 1~30만 까지 더해야 될 수 있음 n(n+1)/2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 30만

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(0); // lower의 결과가 없는 경우에 null 반환 방지
        treeSet.add(N + 1); // higher의 결과가 없는 경우 null 반환 방지

        int[] depth = new int[N + 2];
        // root 값 depth 입력시 0이 될 수 있도록 0이 아닌 -1로 
        depth[0] = -1;
        depth[N + 1] = -1;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            // 깊이가 더 깊은 수를 선택해 바로 그 밑에 위치
            depth[num] = Math.max(depth[treeSet.lower(num)], depth[treeSet.higher(num)]) + 1;
            treeSet.add(num);

            cnt += depth[num];
            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
}
