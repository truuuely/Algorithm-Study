import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        /**
         * Collections.sort는 최악의 경우에도 nlogn을 보장
         * Arrays.sort는 평균은 nlogn이지만 최악의 경우 n^2
         */
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        arr.forEach(i -> sb.append(i).append('\n'));
        System.out.println(sb);
    }
}
