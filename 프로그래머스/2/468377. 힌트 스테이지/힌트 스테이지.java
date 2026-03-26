import java.util.*;

class Solution {
    Map<String, Integer> memo = new HashMap<>();

    public int solution(int[][] cost, int[][] hint) {
        return dfs(0, new int[cost.length + 1], cost, hint);
    }

    private int dfs(int idx, int[] hints, int[][] cost, int[][] hint) {
        if (idx == cost.length) return 0;

        String key = idx + Arrays.toString(Arrays.copyOfRange(hints, idx + 1, hints.length));
        if (memo.containsKey(key)) return memo.get(key);

        int curSolve = cost[idx][Math.min(hints[idx + 1], cost.length - 1)];

        int res = curSolve + dfs(idx + 1, hints.clone(), cost, hint);

        if (idx < cost.length - 1) {
            int[] nextHints = hints.clone();
            for (int i = 1; i < hint[idx].length; i++) {
                if (nextHints[hint[idx][i]] < cost.length - 1) nextHints[hint[idx][i]]++;
            }
            res = Math.min(res, curSolve + hint[idx][0] + dfs(idx + 1, nextHints, cost, hint));
        }

        memo.put(key, res);
        return res;
    }
}