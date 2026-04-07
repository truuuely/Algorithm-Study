import java.util.HashSet;

class Solution {
    private final int CODE_SIZE = 5;
    private int[][] tried;
    private int[] answers;
    private int ret;

    public int solution(int n, int[][] q, int[] ans) { // n까지의
        tried = q;
        answers = ans;

        HashSet<Integer> codes = new HashSet<>();
        initCombination(n, 1, codes);

        return ret;
    }

    private void initCombination(int n, int start, HashSet<Integer> codes) {
        if (codes.size() >= 5) {
            if (check(codes)) {
                ret += 1;
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            codes.add(i);
            initCombination(n, i + 1, codes);
            codes.remove(i);
        }
    }

    private boolean check(HashSet<Integer> codes) {
        boolean isPossible = true;
        for (int i = 0; i < tried.length; i++) {
            int cnt = 0;
            for (int j = 0; j < tried[i].length; j++) {
                if (codes.contains(tried[i][j])) {
                    cnt += 1;
                }
            }

            if (cnt != answers[i]) {
                isPossible = false;
                break;
            }
        }

        return isPossible;
    }
}