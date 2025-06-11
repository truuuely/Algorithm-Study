import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        List<Integer> list = new ArrayList<>();
        int cnt = 1;
        while (!queue.isEmpty()) {
            if (cnt != K) {
                cnt += 1;
                queue.add(queue.poll());
            } else {
                list.add(queue.poll());
                cnt = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        list.stream().forEach(i -> sb.append(i).append(", "));
        sb.delete(sb.length() - 2, sb.length());
        sb.append('>');
        System.out.println(sb);
    }
}