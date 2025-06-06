import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder str = new StringBuilder();
        str.append(br.readLine());

        int m = Integer.parseInt(br.readLine()); // 50만
        int cursor = str.length();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("L")) {
                // 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                if (cursor > 0) {
                    cursor -= 1;
                }
            } else if (command.equals("D")) {
                // 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                if (cursor < str.length()) {
                    cursor += 1;
                }
            } else if (command.equals("B")) {
                // 커서 왼쪽에 있는 문자를 삭제 (커서가 문장의 맨 앞이면 무시됨)
                if (cursor > 0 && str.length() > 0) {
                    str.deleteCharAt(cursor - 1);
                    cursor -= 1;
                }
            } else if (command.equals("P")) {
                // s라는 문자를 커서 왼쪽에 추가
                String s = st.nextToken();
                str.insert(cursor++, s);
            }
        }

        System.out.println(str);
    }
}
