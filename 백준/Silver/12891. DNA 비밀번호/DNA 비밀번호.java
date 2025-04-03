import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken()); // 전체 문자열 길이
        int p = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
        String wholeString = br.readLine(); // 문자열

        st = new StringTokenizer(br.readLine());
        int[] minCount = new int[4]; // a, c, g, t 최소 개수
        for (int i = 0; i < minCount.length; i++) {
            minCount[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int[] count = new int[4]; // a, c, g, t
        for (int i = 0; i < s; i++) {
            char ch = wholeString.charAt(i);
            count[getIndex(ch)]++;

            if (i >= p - 1) { // 비밀번호 유효성 체크
                if (i >= p) { // 범위에 포함되지 않은 문자 개수 제외
                    char lastCh = wholeString.charAt(i - p);
                    if (count[getIndex(lastCh)] > 0) {
                        count[getIndex(lastCh)]--;
                    }
                }

                boolean canUse = true;
                for (int j = 0; j < minCount.length; j++) { // 최소 개수와 비교
                    if (minCount[j] > count[j]) {
                        canUse = false;
                        break;
                    }
                }

                if (canUse) {
                    ans++;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    private static int getIndex(char ch) {
        if (ch == 'A') {
            return 0;
        } else if (ch == 'C') {
            return 1;
        } else if (ch == 'G') {
            return 2;
        } else {
            return 3;
        }
    }

}