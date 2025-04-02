import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 응시자 수. 최대 1000
        int k = Integer.parseInt(st.nextToken()); // 수상자 수

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr, (o1, o2) -> o2 - o1);
        bw.write(String.valueOf(arr.get(k - 1)));
        bw.flush();
        bw.close();
    }

}