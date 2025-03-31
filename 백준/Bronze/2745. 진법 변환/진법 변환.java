import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            int num = c >= 'A' && c <= 'Z' ? c - 'A' + 10 : c - '0';

            ans += Math.pow(b, n.length() - 1 - i) * num;
        }

        System.out.println(ans);

    }
}