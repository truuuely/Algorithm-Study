import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 레일 위 초밥 접시 수. 300만 이하
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수. 3000개 이하
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수. k <= N, 최대 3000
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호. c <= d

        int[] sushies = new int[N];
        for (int i = 0; i < N; i++) {
            sushies[i] = Integer.parseInt(br.readLine());
        }

        int[] kinds = new int[d + 1];
        int cnt = 0;
        int coupon = 0;
        for (int i = 0; i < k; i++) {
            if (kinds[sushies[i]]++ == 0) { // 종류 개수 체크
                cnt += 1;
            }
        }

        coupon = kinds[c] == 0 ? 1 : 0; // 쿠폰으로 먹은 종류 체크

        int ans = cnt + coupon;

        int left = 0;
        int right = k - 1;
        // 슬라이딩 윈도우
        while (left < N) {
            if (--kinds[sushies[left++]] == 0) { // 맨 왼쪽 초밥 뺐을 때 해당 초밥 개수가 0이면 cnt--
                cnt -= 1;
            }

            right += 1;
            if (++kinds[sushies[right % N]] == 1) { // 오른쪽 범위 늘렸을 때 그 초밥이 새로 추가된 거면
                cnt += 1;
            }

            coupon = kinds[c] == 0 ? 1 : 0;

            ans = Math.max(ans, cnt + coupon);
        }

        System.out.println(ans);
    }

}