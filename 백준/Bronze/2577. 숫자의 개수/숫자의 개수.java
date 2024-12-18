import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int b = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int c = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        String num = String.valueOf(a * b * c);

        int[] arr = new int[10];

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            arr[ch - '0']++;
        }
        Arrays.stream(arr).forEach(ans -> System.out.println(ans));

    }
}