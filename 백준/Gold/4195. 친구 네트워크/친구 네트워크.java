import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;
    private static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int f = Integer.parseInt(br.readLine()); // 네트워크 수. 100,000
            parent = new int[2 * f];
            count = new int[2 * f]; // 각 노드의 친구수
            Arrays.fill(count, 1); // 최초 친구수는 1

            for (int j = 0; j < parent.length; j++) {
                parent[j] = j; // 루트 초기화
            }

            int idx = 0;
            Map<String, Integer> name = new HashMap<>();
            for (int j = 0; j < f; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if (!name.containsKey(name1)) {
                    name.put(name1, idx++);
                }

                if (!name.containsKey(name2)) {
                    name.put(name2, idx++);
                }

                System.out.println(union(name.get(name1), name.get(name2)));
            }
        }
    }

    // x와 y를 union 할 때, x 혹은 y의 부모를 x 혹은 y의 루트 노드값으로 갱신
    // 네트워크 개수도 루트노드의 네트워크 개수만 업데이트
    public static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return count[x];
        }

        if (x < y) {
            parent[y] = x;
            return count[x] += count[y];
        } else {
            parent[x] = y;
            return count[y] += count[x];
        }
    }

    // x가 속한 그래프의 루트 노드 반환
    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }
}