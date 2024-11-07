import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n의 생성자 구하기

        int ans = 0; // 생성자
        while (true) {
            // ans++ 하면서
            // ans과 ans의 각 자리수를 더한 값 == n 이면 break;
            ans++;
            if (isDecompositionSum(ans, n)) {
                break;
            }

            if (ans > n) {
                ans = 0;
                break;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    private static boolean isDecompositionSum(int num, int n) {
        String numToStr = String.valueOf(num);
        int sum = num;
        for (int i = 0; i < numToStr.length(); i++) {
            int number = numToStr.charAt(i) - '0';
            sum += number;
        }

        return sum == n;
    }

}