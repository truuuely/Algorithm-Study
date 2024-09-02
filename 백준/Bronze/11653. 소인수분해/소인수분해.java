import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        primeFactorization(n);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int primeFactorization(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                sb.append(i + "\n");
                return primeFactorization(n / i);
            }
        }
        return -1;
    }
}