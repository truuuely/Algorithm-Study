import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int widthMax = 0, heightMax = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            // w, h 중 큰 것 중에 Max
            // w, h 중 작은 것 중에 Max
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            int max = Math.max(w, h);
            int min = Math.min(w, h);
            
            widthMax = Math.max(widthMax, max);
            heightMax = Math.max(heightMax, min);
        }

        return widthMax * heightMax;
    }
}