class Solution {
    public int solution(int[] dot) {
        int x = dot[0], y = dot[1];
        if (x * y > 0) {
            return x > 0 ? 1 : 3;
        } else {
            return x > 0 ? 4 : 2;
        }
    }
}