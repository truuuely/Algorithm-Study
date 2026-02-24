import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_VALUE = 1_000_000_001;
    static final int MIN_VALUE = 0;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 100,000
        int M = Integer.parseInt(st.nextToken()); // 100,000

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree segmentTree = new SegmentTree();
        segmentTree.initMin(1, 1, N);
        segmentTree.initMax(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            // 최솟값, 최댓값 순서로 출력
            int min = segmentTree.getMinValue(1, 1, N, l, r);
            int max = segmentTree.getMaxValue(1, 1, N, l, r);
            sb.append(min).append(' ').append(max).append('\n');
        }

        System.out.println(sb);
    }

    static class SegmentTree {
        int[] min = new int[4 * N + 1];
        int[] max = new int[4 * N + 1];

        public int initMin(int node, int start, int end) {
            if (start == end) {
                return min[node] = arr[start];
            }

            int mid = (start + end) / 2;
            return min[node] = Math.min(initMin(node * 2, start, mid), initMin(node * 2 + 1, mid + 1, end));
        }

        public int initMax(int node, int start, int end) {
            if (start == end) {
                return max[node] = arr[start];
            }

            int mid = (start + end) / 2;
            return max[node] = Math.max(initMax(node * 2, start, mid), initMax(node * 2 + 1, mid + 1, end));
        }

        // l-r 사이의 최소값
        public int getMinValue(int node, int start, int end, int l, int r) {
            if (l > end || r < start) {
                return MAX_VALUE;
            }

            if (l <= start && end <= r) {
                return min[node];
            }

            int mid = (start + end) / 2;
            return Math.min(getMinValue(node * 2, start, mid, l, r), getMinValue(node * 2 + 1, mid + 1, end, l, r));
        }

        public int getMaxValue(int node, int start, int end, int l, int r) {
            if (l > end || r < start) {
                return MIN_VALUE;
            }

            if (l <= start && end <= r) {
                return max[node];
            }

            int mid = (start + end) / 2;
            return Math.max(getMaxValue(node * 2, start, mid, l, r), getMaxValue(node * 2 + 1, mid + 1, end, l, r));
        }
    }
}