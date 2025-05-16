import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) { // t <= 30
            String line = br.readLine();

            // 투포인터 => O(n)
            int left = 0, right = line.length() - 1;
            int result = 0;

            while (left < right) {
                if (line.charAt(left) == line.charAt(right)) {
                    left++;
                    right--;
                }
                else {
                    boolean skipLeft = isPalindrome(line, left + 1, right);
                    boolean skipRight = isPalindrome(line, left, right - 1);

                    if (skipLeft || skipRight) {
                        result = 1;
                    }
                    else {
                        result = 2;
                    }
                    break;
                }
            }

            System.out.println(result);
        }
    }

    private static boolean isPalindrome(String line, int left, int right) {
        while (left < right) {
            if (line.charAt(left) != line.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}