import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            list.add(Character.getNumericValue(charArray[i]));
        }
        list.sort(Collections.reverseOrder());
        list.forEach(System.out::print);
    }
}