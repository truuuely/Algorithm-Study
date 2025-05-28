import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람. 50만 이하
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람. 50만 이하

        Set<String> neverHeard = new HashSet<>();
        for (int i = 0; i < N; i++) {
            // 듣도 못한 사람들
            neverHeard.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String neverSeen = br.readLine();
            if (neverHeard.contains(neverSeen)) {
                list.add(neverSeen);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');

        Collections.sort(list);
        for (String s : list) {
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }
}
