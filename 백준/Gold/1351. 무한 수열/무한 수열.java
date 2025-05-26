import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static Map<Long, Long> map = new HashMap<>();
    private static long P;
    private static long Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken()); //
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        map.put(0L, 1L);
        System.out.println(getA(N));
    }

    private static long getA(long N) {
        if (map.containsKey(N)) {
            return map.get(N);
        }

        long result = getA(N / P) + getA(N / Q);
        map.put(N, result);
        return result;
    }

}