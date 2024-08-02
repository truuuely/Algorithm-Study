import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if (first == 0 && second == 0) {
                break;
            }

            if (second % first == 0) { // first가 second의 약수면
                sb.append("factor\n");
            }
            else if (first % second == 0) { // first가 second의 배수이면
                sb.append("multiple\n");
            }
            else {
                sb.append("neither\n");
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}