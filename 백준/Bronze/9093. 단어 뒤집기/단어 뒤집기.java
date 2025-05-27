import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {// I am happy
                String word = st.nextToken();
                for (int j = word.length() - 1; j >= 0; j--) {
                    sb.append(word.charAt(j));
                }
                sb.append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
