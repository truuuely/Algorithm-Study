class Solution {
    long maxLeaf = 0;
    long D_LIMIT, S_LIMIT;

    public long solution(int dist_limit, int split_limit) {
        D_LIMIT = dist_limit;
        S_LIMIT = split_limit;

        // 초기 상태: 루트 아래 노드 1개 (깊이 1, 현재 층 노드 1개, 현재 분배도 1, 총 분배노드 0, 총 리프 0)
        dfs(1, 1, 0, 0);

        return (int) maxLeaf;
    }

    void dfs(long currentWidth, long currentSplit, long totalDist, long totalLeaf) {
        // 1. 현재 층의 노드들을 전부 리프 노드로 만들고 종료하는 경우
        maxLeaf = Math.max(maxLeaf, totalLeaf + currentWidth);

        // 2. 현재 층 노드 중 일부를 분배 노드로 전환 시도
        // 2개로 나눌지, 3개로 나눌지 결정
        for (int c : new int[]{2, 3}) {
            if (currentSplit * c <= S_LIMIT) {
                // 이번 층에서 분배 노드로 쓸 수 있는 최대 개수
                // 남은 dist_limit과 현재 층의 노드 수(currentWidth) 중 작은 값
                long canDist = Math.min(currentWidth, D_LIMIT - totalDist);
                
                if (canDist > 0) {
                    // 다음 층으로 내려감
                    // 다음 층 노드 수 = canDist * c
                    // 새로 추가된 리프 노드 = 현재 층 노드 - 분배 노드(canDist)
                    dfs(canDist * c, currentSplit * c, totalDist + canDist, totalLeaf + (currentWidth - canDist));
                }
            }
        }
    }
}