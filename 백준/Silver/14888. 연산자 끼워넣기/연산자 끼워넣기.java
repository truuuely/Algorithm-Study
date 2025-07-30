import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        num = new int[N]; // 식의 결과와 중간값은 항상 -10억 <= x <= 10억

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] op = new int[4]; // +, -, *, /
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < op.length; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }


        dfs(0, num[0], op);
        System.out.println(max + "\n" + min);
    }

    private static void dfs(int depth, int res, int[] op) {
        if (depth == num.length - 1) {
            // 최대값, 최소값 갱신
            max = Math.max(res, max);
            min = Math.min(res, min);

            return;
        }

        for (int i = 0; i < op.length; i++) {
            if (op[i] > 0) { //
                int[] nextOp = Arrays.copyOf(op, op.length);
                nextOp[i] = op[i] - 1;

                switch (i) {
                    case 0 :
                        dfs(depth + 1, res + num[depth + 1], nextOp);
                        break;
                    case 1 :
                        dfs(depth + 1, res - num[depth + 1], nextOp);
                        break;
                    case 2 :
                        dfs(depth + 1, res * num[depth + 1], nextOp);
                        break;
                    case 3 :
                        dfs(depth + 1, res / num[depth + 1], nextOp);
                }
            }
        }
    }
}
