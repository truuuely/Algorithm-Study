class Solution {
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        // 요청을 돌면서
        for (int i = 0; i < requests.length; i++) { // 100
            String alphabet = requests[i];
            
            // 붙어있는지 확인
            for (int j = 0; j < storage.length; j++) {
                if (alphabet.length() == 2) { // 모든 알파벳 다 꺼내기
                    storage[j].replaceAll(alphabet, "0");
                    break;
                }
            
                for (int k = 0; k < storage[j].length(); k++) {
                    char c = storage[j].charAt(k);
                    if (c == alphabet.charAt(0)) {
                        
                    }
                }
                
            }
        }
        return answer;
    }
}