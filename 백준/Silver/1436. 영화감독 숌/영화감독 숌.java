import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 1, ans = 666;
        // n == cnt 될 때까지 ans++를 반복하면서
        // ans 에 '666'이 포함되어 있으면 cnt++
        while (cnt != n) {
            ans++;

            if (String.valueOf(ans).contains("666")) {
                cnt++;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

}