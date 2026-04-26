import java.util.HashMap;
import java.util.Map;

class Solution {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            if (map.get(s) > 0) {
                map.put(s, map.get(s) - 1);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                answer = key;
            }
        }

        return answer;
    }
}