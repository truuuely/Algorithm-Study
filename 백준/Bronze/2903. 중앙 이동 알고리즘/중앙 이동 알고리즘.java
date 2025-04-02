import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        // 반복 횟수 | 행의 점 개수
        // 1번     |    3
        // 2번     |    5
        // 3번     |    9
        // n번 = 1 + 2의 n승
        int row = (int) (Math.pow(2, n) + 1);

        bw.write(String.valueOf(row * row));
        bw.flush();
        bw.close();
    }
}