import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> wordList = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();

        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            wordList.add(input);
            wordSet.add(input);
        }

        List<String> result = new ArrayList<>();

        for (String word : wordList) {
            int len = word.length();
            for (int i = 1; i < len; i++) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i);

                if (wordSet.contains(prefix) && wordSet.contains(suffix)) {
                    result.add(word);
                    break; // 복합어임이 판명되면 더 쪼갤 필요 없음
                }
            }
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (String res : result) {
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }
}