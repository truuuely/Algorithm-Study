import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); /// 100만 이하

        TreeSet<String> people = new TreeSet<>(Comparator.reverseOrder()); // 사전 순의 역순으로 출력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            // 동명이인이 없으므로 트리셋에 있으면 퇴근이고 없으면 출근
            if (people.contains(name)) {
                people.remove(name);
            } else {
                people.add(name);
            }
        }

        people.forEach(System.out::println);

    }
}