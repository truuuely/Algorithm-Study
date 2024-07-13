import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            int[] alphabets = new int['z' - 'a' + 1];
            // 첫번째 알파벳 +1
            alphabets[s.charAt(0) - 'a'] = 1;
            for (int j = 1; j < s.length(); j++) {
                // 두번째부터 n이랑 n-1이랑 같으면 넘어가기
                //                     다르면 n번째 알파벳 자리에 +1
                if (s.charAt(j) != s.charAt(j - 1)) {
                    alphabets[s.charAt(j) - 'a']++;
                }
            }

            boolean isGroupWord = true;
            for (int j = 0; j < alphabets.length; j++) {
                if (alphabets[j] > 1) { // 그룹 X
                    isGroupWord = false;
                    break;
                }
            }

            if (isGroupWord) {
                cnt++;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}