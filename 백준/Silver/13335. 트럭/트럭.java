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

        Queue<Integer> road = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            road.add(0); // 다리를 0으로 표시
        }

        int time = 0;
        int weightSum = 0;
        while (!road.isEmpty()) {
            time++;
            weightSum -= road.poll();
            if (!trucks.isEmpty()) { // 다음 트럭이 있을 때만 다리에 0 추가됨
                if (trucks.peek() + weightSum <= L) {
                    weightSum += trucks.peek();
                    road.add(trucks.poll());
                } else {
                    road.add(0);
                }
            }
        }

        System.out.println(time);
    }
}