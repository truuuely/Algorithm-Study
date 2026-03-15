import java.util.*;

class Solution {
    // 메시지: 최대 2만, 스포일러 1000개
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;

        boolean[] isBlocked = new boolean[message.length()];
        for (int i = 0; i < spoiler_ranges.length; i++) {
            int start = spoiler_ranges[i][0];
            int end = spoiler_ranges[i][1];

            Arrays.fill(isBlocked, start, end + 1, true);
        }

        Map<Integer, String> wordByIdx = new HashMap<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        int sIdx = 0;
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == ' ') {
                wordByIdx.put(sIdx, sb.toString());
                treeMap.put(sIdx, sb.toString());
                sIdx = i + 1;
                sb = new StringBuilder();
                continue;
            }

            sb.append(c);
        }

        if (sb.length() > 0) {
            wordByIdx.put(sIdx, sb.toString());
            treeMap.put(sIdx, sb.toString());
        }

        Set<String> notImportantWords = getNotImportantWords(wordByIdx, isBlocked);

        for (int idx : treeMap.keySet()) {
            String word = treeMap.get(idx);

            if (!notImportantWords.contains(word)) {
                answer += 1;
                notImportantWords.add(word);
            }
        }

        return answer;
    }

    private static Set<String> getNotImportantWords(Map<Integer, String> wordByIdx, boolean[] isBlocked) {
        Set<String> notImportant = new HashSet<>();
        for (int idx : wordByIdx.keySet()) {
            String word = wordByIdx.get(idx);

            boolean isCensoredWord = false;
            for (int i = idx; i < idx + word.length(); i++) {
                if (isBlocked[i]) {
                    isCensoredWord = true;
                    break;
                }
            }

            if (!isCensoredWord) {
                notImportant.add(word);
            }
        }

        return notImportant;
    }
}