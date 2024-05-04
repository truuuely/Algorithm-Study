import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] students = new boolean[30];

        for (int i = 0; i < 28; i++) {
            int x = Integer.parseInt(br.readLine());
            students[x - 1] = true;
        }

        for (int i = 0; i < students.length; i++) {
            if (!students[i]) {
                System.out.println(i + 1);
            }
        }
    }
}