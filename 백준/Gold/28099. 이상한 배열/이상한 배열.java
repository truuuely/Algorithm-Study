import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 20만 이하
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // T * N <= 20만
            int[] nums = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<Integer, Integer> countMap = new HashMap<>(); // 숫자가 몇 개 나왔는지
            for (int j = 0; j < N; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
                countMap.put(nums[j], countMap.getOrDefault(nums[j], 0) + 1);
            }

            // 2개 이상 나오는 숫자만 저장하는 set
            Set<Integer> set = new HashSet<>();
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() > 1) {
                    set.add(entry.getKey());
                }
            }

            // 각 숫자의 인덱스를 저장
            HashMap<Integer, List<Integer>> check = new HashMap<>();

            // 오큰수 위치 저장
            int[] oIdx = new int[N];
            Arrays.fill(oIdx, N + 1);

            Stack<Integer> stack = new Stack<>();

            // 오큰수 구하고 check
            for (int j = 0; j < N; j++) {
                // 중복 숫자면 check에 인덱스 저장
                if (set.contains(nums[j])) {
                    check.putIfAbsent(nums[j], new ArrayList<>());
                    check.get(nums[j]).add(j);
                }

                // 오큰수 찾기
                while (!stack.isEmpty() && nums[j] > nums[stack.peek()]) {
                    oIdx[stack.pop()] = j;
                }

                stack.push(j);
            }

            String ans = "Yes";
            for (int j = 0; j < N; j++) {
                if (check.containsKey(nums[j])) {
                    List<Integer> indices = check.get(nums[j]);

                    if (oIdx[j] < indices.get(indices.size() - 1)) {
                        ans = "No";
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}