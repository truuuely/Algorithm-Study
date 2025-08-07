import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] inorder;
    static Map<Integer, Integer> inorderIdxByValue = new HashMap<>();
    static int[] postorder;
    static int[] preorder;
    static int preIdx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        inorder = new int[n + 1];
        postorder = new int[n + 1];
        preorder = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            inorderIdxByValue.put(inorder[i], i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        setPreorder(1, n, 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(preorder[i]).append(' ');
        }

        System.out.println(sb);
    }



    static void setPreorder(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) {
            return;
        }

        int root = postorder[pe];
        preorder[preIdx++] = root;

        int rootIdxInorder = inorderIdxByValue.get(root);
        int leftSize = rootIdxInorder - is;

        // left
        setPreorder(is, rootIdxInorder - 1, ps, ps + leftSize - 1);

        // right
        setPreorder(rootIdxInorder + 1, ie, ps + leftSize, pe - 1);
    }
}