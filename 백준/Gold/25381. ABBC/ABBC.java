import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A는 뒤에 B가 오는 경우, B는 뒤에 C가 오는 경우 지울 수 있다.
 * C는 뒤에 어떤 알파벳이 오더라도 지울 수 없다.
 * -> C를 먼저 지운다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int cnt = 0;
        Queue<Integer> a = new LinkedList<>(); // A의 인덱스를 넣는 큐
        Queue<Integer> b = new LinkedList<>(); // B의 인덱스를 넣는 큐
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == 'A') {
                a.add(i);
            } else if (c == 'B') {
                b.add(i);
            } else {
                // C일 때: b에 있는 인덱스 확인해서 C의 인덱스보다 앞에 있으면 poll
                if (!b.isEmpty() && b.peek() < i) {
                    b.poll();
                    cnt++;
                }
            }
        }

        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.peek() < b.peek()) {
                a.poll();
                b.poll();
                cnt++;
            }
            else { // a > b 인 경우, BA... 가 있다는 것이므로 시행할 수 없는 B를 빼줌
                b.poll();
            }
        }

        System.out.println(cnt);
    }
}
