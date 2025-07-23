import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 1 <= K <= 100
        int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 100,000

        st = new StringTokenizer(br.readLine());
        ArrayList<Long> list = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }

        PriorityQueue<Long> queue = new PriorityQueue<>(list); // N번째 수를 구하기 위해 정렬 되어있어야 함

        long num = 0;
        while (N-- > 0) {
            num = queue.poll();
            for (long i : list) {
                long multiple = num * i;
                queue.add(multiple);

                if (num % i == 0) {
                    break;
                }
            }
        }

        System.out.println(num);
    }
}