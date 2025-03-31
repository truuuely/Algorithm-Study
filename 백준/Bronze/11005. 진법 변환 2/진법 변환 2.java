import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        while (n != 0) {
            list.add(n % b);
            n /= b;
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = list.size() - 1; i >= 0; i--) {
            Integer num = list.get(i);
            if (num >= 10) {
                buffer.append(Character.toChars('A' + num - 10));
            }
            else {
                buffer.append(num);
            }
        }

        System.out.println(buffer);
    }
}