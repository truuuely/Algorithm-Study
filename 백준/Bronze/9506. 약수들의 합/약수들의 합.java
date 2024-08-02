import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            }

            String s = "";
            int x = 0;
            for (int i = 1; i <= n/2; i++) {
                if (n % i == 0) { // i는 n의 약수
                    x += i;
                    s += i + " + ";
                }
            }

            if (n == x) {
                s = n + " = " + s.substring(0, s.lastIndexOf("+"));
            }
            else {
                s = n + " is NOT perfect.";
            }

            sb.append(s + "\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}