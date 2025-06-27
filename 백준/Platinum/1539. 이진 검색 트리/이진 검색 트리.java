import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<Integer> treeSet = new TreeSet<>();
        int[] depth = new int[N]; // depth[i] 는 i의 깊이

        long heightSum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine()); // 0 <= num < N

            // num의 높이 구하기
            // num보다 큰 것 중 가장 작은 거, 혹은 작은 것 중 가장 큰 거의 자식으로 간다
            int lower = treeSet.lower(num) == null ? 0 : depth[treeSet.lower(num)];
            int higher = treeSet.higher(num) == null ? 0 : depth[treeSet.higher(num)];
            depth[num] = Math.max(lower, higher) + 1;
            treeSet.add(num);

            heightSum += depth[num];
        }

        System.out.println(heightSum);
    }
}