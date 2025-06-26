import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static String nStr;
    public static char[] N;
    public static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nStr = br.readLine();
        N = nStr.toCharArray();

        for (int i = 0; i < N.length; i++) {
            dfs(i, i, String.valueOf(N[i]), String.valueOf(N[i]));
        }

        System.out.println(set.size());
    }

    public static void dfs(int L, int R, String s, String path) {
        if (L == 0 && R == N.length - 1) {
            set.add(path);
            return;
        }

        if (L - 1 >= 0) {
            dfs(L - 1, R, N[L - 1] + s, path + " " + N[L - 1] + s);
        }

        if (R + 1 < N.length) {
            dfs(L, R + 1, s + N[R + 1], path + " " + s + N[R + 1]);
        }
    }
}
