import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] isSum = new boolean[2000001];
    /**
     * 수열 S가 주어졌을 때, 수열 S의 부분 수열의 합으로 나올 수 없는 가장 작은 자연수를 구하는 프로그램을 작성하시오.
     *
     * 예를 들어, S = [5, 1, 2]인 경우에 1, 2, 3(=1+2), 5, 6(=1+5), 7(=2+5), 8(=1+2+5)을 만들 수 있다.
     * 하지만, 4는 만들 수 없기 때문에 정답은 4이다.*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);

        for (int i = 0; i < isSum.length; i++) {
            if (!isSum[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void backtracking(int index, int sum) {
        if (index == arr.length) {
            isSum[sum] = true;
            return;
        }

        backtracking(index + 1, sum + arr[index]);
        backtracking(index + 1, sum);
    }

}
