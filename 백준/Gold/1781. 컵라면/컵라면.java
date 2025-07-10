import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 20만

        // 데드라인 짧은 순, 컵라면 많은 순
        PriorityQueue<Problem> queue = new PriorityQueue<>((o1, o2)
                -> o1.deadline == o2.deadline ? o2.cupNoodle - o1.cupNoodle : o1.deadline - o2.deadline);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int cupNoodle = Integer.parseInt(st.nextToken());

            queue.add(new Problem(deadline, cupNoodle));
        }

        PriorityQueue<Integer> selected = new PriorityQueue<>();
        while (!queue.isEmpty()) {
            Problem p = queue.poll();

            if (selected.size() < p.deadline) { // 풀 수 있는 문제면 일단 추가
                selected.add(p.cupNoodle);
            } else {
                if (selected.peek() < p.cupNoodle) {
                    selected.poll();
                    selected.add(p.cupNoodle);
                }
            }
        }

        int sum = 0;
        while (!selected.isEmpty()) {
            sum += selected.poll();
        }

        System.out.println(sum);
    }
}

class Problem {
    int deadline;
    int cupNoodle;

    public Problem(int deadline, int cupNoodle) {
        this.deadline = deadline;
        this.cupNoodle = cupNoodle;
    }
}
