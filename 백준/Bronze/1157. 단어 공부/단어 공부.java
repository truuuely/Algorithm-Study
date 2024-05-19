import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.toUpperCase();

        int[] alphabets = new int['Z' - 'A' + 1];

        for (int i = 0; i < s.length(); i++) {
            int chIndex = s.charAt(i) - 'A';
            alphabets[chIndex]++;
        }

        int maxIndex = -1; // 어떤 알파벳이
        int maxValue = -1; // 몇 번 나왔다
        boolean isDuplicatedVal = false;
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] > maxValue) {
                maxIndex = i;
                maxValue = alphabets[i];
                isDuplicatedVal = false;
            } else if (alphabets[i] == maxValue) {
                isDuplicatedVal = true;
            }
        }

        System.out.println(isDuplicatedVal ? "?" : (char) (maxIndex + 'A'));
    }
}