import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 트럭 수. 최대 1000
        int w = Integer.parseInt(input[1]); // 다리 길이. 최대 100
        int L = Integer.parseInt(input[2]); // 다리 최대 하중. 최소 10, 최대 1000

        Queue<Integer> trucks = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        int[] road = new int[w]; // 다리 길이만큼 0
        
        // 첫 번째 트럭먼저 다리 위에 올리기 (while 문 종료 조건 때문)
        int time = 1;
        road[w - 1] = trucks.poll();
        int weightSum = road[w - 1];
        while (weightSum > 0) {
            time += 1;

            // 다리 위 트럭 한 칸씩 이동
            for (int i = 0; i < w; i++) {
                if (road[i] != 0) { // 트럭이 있다
                    if (i == 0) { // 다리를 빠져나간다
                        weightSum -= road[i];
                        road[i] = 0;
                    } else { // 건너는 중이다
                        road[i - 1] = road[i];
                        road[i] = 0;
                    }
                }
            }

            // 다음 트럭 다리 위로
            if (!trucks.isEmpty() && trucks.peek() + weightSum <= L) {
                road[w - 1] = trucks.poll();
                weightSum += road[w - 1];
            }
        }

        System.out.println(time);
    }
}