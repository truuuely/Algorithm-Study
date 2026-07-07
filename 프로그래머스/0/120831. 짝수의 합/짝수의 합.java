class Solution {
    public int solution(int n) {
 // 2 + 4 + 6 + ... + n = 2 (1 + 2 + 3 .. + n/2) = 2 * (n/2 * (n/2 + 1)/2)
        n = n % 2 == 0 ? n : n - 1;
        return 2 * (n/2 * (n/2 + 1) / 2);
    }
}