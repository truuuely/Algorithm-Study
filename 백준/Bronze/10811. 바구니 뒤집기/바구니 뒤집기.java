import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] basket = new int[n + 1];
        for (int i = 1; i < basket.length; i++) {
            basket[i] = i;
        }

        for (int a = 0; a < m; a++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            Stack<Integer> stack = new Stack<>();
            for (int b = i; b <= j; b++) {
                stack.push(basket[b]);
            }

            for (int b = i; b <= j; b++) {
                basket[b] = stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < basket.length; i++) {
            sb.append(basket[i] + " ");
        }
        System.out.println(sb.toString());
    }
}