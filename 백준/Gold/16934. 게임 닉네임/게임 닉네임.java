import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Node root = new Node();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String nickname = br.readLine();
            sb.append(insertAndGetNickname(nickname)).append("\n");
        }
        System.out.print(sb);
    }

    private static String insertAndGetNickname(String nickname) {
        Node cur = root;
        String result = "";
        boolean found = false;

        for (int i = 0; i < nickname.length(); i++) {
            char c = nickname.charAt(i);

            // 처음으로 새로운 길을 만들어야 하는 시점 찾기
            if (!found && !cur.children.containsKey(c)) {
                result = nickname.substring(0, i + 1);
                found = true;
            }

            // 노드가 없으면 생성. 있으면 이동
            cur.children.putIfAbsent(c, new Node());
            cur = cur.children.get(c);
            cur.prefixCount++;
        }

        // 전체를 다 훑었는데도 새로운 접두사가 없다면
        if (!found) {
            result = nickname;
        }

        // 완전히 똑같은 닉네임이 이미 있었다면 숫자 붙이기
        cur.endCount++;
        if (cur.endCount > 1) {
            result = nickname + cur.endCount;
        }

        return result;
    }

    static class Node {
        // 자식 노드들을 저장 (글자 -> 노드)
        Map<Character, Node> children = new HashMap<>();

        int prefixCount = 0; // 해당 노드까지를 접두사로 가지는 단어의 수
        int endCount = 0; // 이 노드에서 끝나는 단어의 전체 등장 횟수
    }
}