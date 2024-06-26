import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] piece = {1, 1, 2, 2, 2, 8};
        for (int i = 0; i < piece.length; i++) {
            int input = Integer.parseInt(st.nextToken());
            sb.append(piece[i] - input + " ");
        }
        System.out.println(sb);
    }
}