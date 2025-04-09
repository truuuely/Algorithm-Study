import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // n이 최대 백만개이기 때문에 단순 반복문으로 오큰수를 찾으면 시간 초과
        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>(); // 오큰수를 구해야할 배열의 인덱스
        stack.push(1);
        for (int i = 2; i <= n; i++) {
            int rightNum = arr[i];
            while (!stack.empty() && arr[stack.peek()] < rightNum) {
                arr[stack.peek()] = rightNum;
                stack.pop();
            }
            stack.push(i);
        }

        // 배열을 끝까지 확인했는데도 오큰수를 구하지 못한 것들은 -1
        while (!stack.empty()) {
            arr[stack.pop()] = -1;
        }

        for (int i = 1; i <= n; i++) {
            bw.append(arr[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}