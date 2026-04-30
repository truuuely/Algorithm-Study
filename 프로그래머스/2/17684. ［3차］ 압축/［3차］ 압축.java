import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        char alphabet = 'A';
        for (int i = 0; i < 26; i++) {
            map.put(Character.toString(alphabet + i), i + 1);
        }

        while (!msg.isEmpty()) {
            String w = String.valueOf(msg.charAt(0));
            
            // 사전에 있는 긴 문자열 찾기
            for (int i = 1; i < msg.length(); i++) {
                if (!map.containsKey(w + msg.charAt(i))) {
                    break;
                }
                
                w += msg.charAt(i);
            }
            
            answer.add(map.get(w));

            msg = msg.substring(w.length());
            if (!msg.isEmpty()) {
                map.put(w + msg.charAt(0), map.size() + 1);
            }
        }

        int[] ans = new int[answer.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
}