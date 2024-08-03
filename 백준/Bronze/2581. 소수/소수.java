import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = -1;
        for (int i = m; i <= n; i++) {
            if (i == 1) {
                continue;
            }

            boolean iIsPrime = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    iIsPrime = false;
                    break;
                }
            }

            if (iIsPrime) {
                sum += i;

                if (min == -1) {
                    min = i;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sum != 0 ? sum + "\n" + min : "-1");
        bw.flush();
        bw.close();
    }
}