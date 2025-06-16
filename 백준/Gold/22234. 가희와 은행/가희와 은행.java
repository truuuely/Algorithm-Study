import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N, T, W, M 은 1 이상 200,000 이하
 * tx는 1 이상 10억 이하
 * 고객 id는 10억 이하의 중복되지 않는 자연수
 * 영업 시작 후 오는 손님들이 오는 시간은 다 다름 (최대 10억)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 이미 줄 서있는 손님 N명
        int T = Integer.parseInt(st.nextToken()); // 손님 당 최대 처리 시간
        int W = Integer.parseInt(st.nextToken()); // 0 ~ W-1 초 동안 처리중인 손님 ID 출력

        Queue<Customer> queue = new LinkedList<>(); // 미리 줄 서있는 손님
        for (int i = 0; i < N; i++) {
            // 미리 줄 서있던 손님 정보
            st = new StringTokenizer(br.readLine());
            int px = Integer.parseInt(st.nextToken()); // id
            int tx = Integer.parseInt(st.nextToken()); // 처리 소요 시간

            queue.add(new Customer(px, tx));
        }

        int M = Integer.parseInt(br.readLine()); // 1초 이후에 은행에 들어온 고객 수
        LinkedList<Customer> lateQueue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int px = Integer.parseInt(st.nextToken()); // id
            int tx = Integer.parseInt(st.nextToken()); // 처리 소요 시간
            int cx = Integer.parseInt(st.nextToken()); // 영업 시작 몇 초 뒤에 왔는지

            lateQueue.add(new Customer(px, tx, cx));
        }

        lateQueue.sort((o1, o2) -> o1.c - o2.c); // 온 순서대로 정렬. Timsort -> O(MlogM)

        int time = 0; // 영업 시작 후 흐르는 시간
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty() && time < W) {
            Customer customer = queue.poll();

            // T초만큼 일처리
            for (int i = 0; i < T; i++) {
                // 중간에 처리 다 됐거나 출력해야되는 시간보다 커지면 break;
                if (customer.t <= 0 || time >= W) {
                    break;
                }

                customer.t -= 1;
                sb.append(customer.p).append('\n');
                time += 1;

                // 시간 흐르면서 손님이 오면 바로바로 줄 섬
                while (!lateQueue.isEmpty() && lateQueue.peek().c <= time) {
                    queue.add(lateQueue.poll());
                }
            }

            // 시간이 남았으면
            if (customer.t > 0) {
                queue.add(customer);
            }
        }

        System.out.println(sb);
    }
}

class Customer {
    int p; // id
    int t; // 처리 소요 시간
    int c; // 영업 시작 후 손님이 도착한 시간

    public Customer(int p, int t) {
        this(p, t, 0);
    }

    public Customer(int p, int t, int c) {
        this.p = p;
        this.t = t;
        this.c = c;
    }
}