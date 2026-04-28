import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            if (!stack.isEmpty() && stack.peek() != num) {
                stack.add(num);
            }
        }
        
        int[] answer = new int[stack.size()];
        int i = 0;
        for (int num : stack) {
            answer[i++] = num;
        }

        return answer;
    }
}