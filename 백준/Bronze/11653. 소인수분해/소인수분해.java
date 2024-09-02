import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

//        primeFactorization(n);

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                sb.append(i + "\n");
                n /= i;
            }
        }

        if (n != 1) {
            sb.append(n);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int primeFactorization(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
//                sb.append(i + "\n");
                return primeFactorization(n / i);
            }
        }
        return -1;
    }
}