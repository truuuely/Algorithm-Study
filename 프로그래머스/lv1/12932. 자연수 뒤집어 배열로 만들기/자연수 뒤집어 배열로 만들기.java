import java.util.Stack;

class Solution {
    public int[] solution(long n) { // 12345
        Stack<Integer> stack = new Stack<>();
        String n2 = ((Long) n).toString();
        
        for(int i = 0; i < n2.length(); i++) {
        	stack.push(n2.charAt(i) - '0');
        }
        
        int[] answer = new int[stack.size()];
        
        for(int i = 0; i < n2.length(); i++) {
        	answer[i] = stack.pop();
        }
        
        return answer;
    }
}