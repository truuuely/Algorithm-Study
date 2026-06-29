class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int oddCnt = 0;
        for (int i = 0; i < num_list.length; i++) {
            oddCnt += num_list[i] % 2 == 1 ? 1 : 0;
        }
        return new int[]{num_list.length - oddCnt, oddCnt};
    }
}