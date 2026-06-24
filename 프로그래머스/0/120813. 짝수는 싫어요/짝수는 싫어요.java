import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] arr = new int[(n + 1)/2];
        
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                arr[idx++] = i;
            }
        }
        return arr;
    }
}