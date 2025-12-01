import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> treeSet = new TreeSet<>((s1, s2) ->
                s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length());

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            treeSet.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (String s : treeSet) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}