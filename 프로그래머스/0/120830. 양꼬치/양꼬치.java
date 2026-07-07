class Solution {
    public int solution(int n, int k) { // 양꼬치 n인분 + 음료수 k개
        return n * 12000 + (k - n/10) * 2000; // 총 얼마?
    }
}