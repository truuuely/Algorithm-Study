import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Edge> nodes = new HashMap<>();

    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        init(edges);

        for (int node : nodes.keySet()) { // 100만개
            Edge edge = nodes.get(node);

            if (edge.in >= 1 && edge.out == 0) { // 막대 (마지막 노드): in 간선만 존재
                answer[2] += 1;
            } else if (edge.in >= 2 && edge.out >= 2) { // 8자 (중심 노드): in/out 간선 모두 2개 이상
                answer[3] += 1;
            } else if (edge.in == 0 && edge.out >= 2) { // 새로 추가된 노드: out만 2개 이상
                answer[0] = node;
            }
        }

        // 도넛 그래프 수 = 새 노드에서 나오는 간선 수 - 막대 그래프 수 - 8자 그래프 수
        answer[1] = nodes.get(answer[0]).out - answer[2] - answer[3];

        return answer;
    }

    private void init(int[][] edges) {

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            nodes.putIfAbsent(from, new Edge(0, 0));
            nodes.putIfAbsent(to, new Edge(0, 0));

            nodes.get(from).out += 1;
            nodes.get(to).in += 1;
        }
    }

    static class Edge {
        int in, out;

        public Edge(int in, int out) {
            this.in = in;
            this.out = out;
        }
    }
}
