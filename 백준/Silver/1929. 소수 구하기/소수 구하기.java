import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] isPrime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        findPrimeNumber();
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]); // (1 ≤ M ≤ N ≤ 1,000,000)
        int N = Integer.parseInt(input[1]);
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }

    public static void findPrimeNumber() {
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = 2; i*j < isPrime.length; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
    }
}