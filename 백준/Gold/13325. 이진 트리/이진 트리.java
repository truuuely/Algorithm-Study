import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] binaryTree;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine()); // 포화 이진 트리의 높이. 노드 개수 = 2^(k+1) - 1

        binaryTree = new int[(int) Math.pow(2, k + 1)]; // 1-based

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i < binaryTree.length; i++) { // 루트 제외 다른 노드에 가중치 줌
            binaryTree[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1);

        System.out.println(ans);
    }

    static int dfs(int node) {
        if (node * 2 >= binaryTree.length) {
            ans += binaryTree[node];
            return binaryTree[node];
        }

        int left = dfs(node * 2);
        int right = dfs(node * 2 + 1);

        ans += binaryTree[node] + Math.abs(left - right);
        return binaryTree[node] + Math.max(left, right);
    }
}