import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int MAX = 40000001;
    private static List<Integer> primeNums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 400만 이하

        initPrimeNums(N); // N 까지의 소수 구하기 (마진 0)

        int[] primeSums = new int[primeNums.size()];
        for (int i = 1; i < primeNums.size(); i++) {
            primeSums[i] = primeSums[i - 1] + primeNums.get(i);
        }

        // 부분합이 N이 되는 경우의 수 카운트. 소수 개수는 최대 약 28만
        int s = 0, e = 1;
        int cnt = 0;
        while (e < primeSums.length) {
            int subSum = primeSums[e] - primeSums[s];// s 초과 e 이하의 부분합
            if (subSum == N) {
                cnt += 1;
                e += 1;
            } else if (subSum < N) {
                e += 1;
            } else {
                s += 1;
            }
        }

        System.out.println(cnt);
    }

    private static void initPrimeNums(int N) {
        Boolean[] isPrime = new Boolean[N + 1];
        primeNums = new ArrayList<>();
        primeNums.add(0); // 계산을 위한 마진

        isPrime[1] = false;
        for (int i = 2; i <= N; i++) {
            // 자기 자신은 소수
            if (isPrime[i] == null) {
                isPrime[i] = true;
                primeNums.add(i);
            }

            // 배수들은 소수가 아님
            for (int j = 2; i * j <= N; j++) {
                if (isPrime[i * j] != null) {
                    continue;
                }
                isPrime[i * j] = false;
            }
        }
    }
}
