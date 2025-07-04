import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static final String YES = "Yes";
    public static final String NO = "No";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 20만 이하
        for (int t = 0; t < T; t++) { // T * N <= 20만
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];

            Map<Integer, List<Integer>> indicesByValue = new HashMap<>(); // <값, 위치>

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

                indicesByValue.computeIfAbsent(arr[i], integer -> new ArrayList<>()) // 없는 경우 배열 생성 후 add
                        .add(i);
            }

            int[] nextGreaterIndex = getNextGreaterIndices(arr);
            String ans = YES;

            for (int i = 0; i < N; i++) {
                List<Integer> indices = indicesByValue.get(arr[i]);

                // 2개 이상 나오지 않았으면 패스
                if (indices.size() < 2) {
                    continue;
                }

                int oIdxOfCurNum = nextGreaterIndex[i]; // i 번째 수의 오큰수 인덱스

                // i의 오큰수가 범위 내에 있으면 이상한 배열 X
                if (oIdxOfCurNum > indices.get(0) && oIdxOfCurNum < indices.get(indices.size() - 1)) {
                    ans = NO;
                    break;
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }

    // 오큰수 인덱스 구하기
    private static int[] getNextGreaterIndices(int[] arr) {
        int[] res = new int[arr.length];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>(); // 오큰수를 구해야하는 값의 인덱스

        for (int i = 0; i < arr.length; i++) {
            // 오큰수를 구해야 하는 거 vs 현재 값 중 현재 값이 더 크면
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                // 오큰수를 구해야 하는 것의 오큰수는 현재 값의 인덱스
                res[stack.pop()] = i;
            }

            stack.push(i);
        }

        return res;
    }
}