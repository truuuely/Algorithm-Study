import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 4 ≤ N ≤ 600

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N]; // 값은 최대 10억
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 윗 덩이 <= 아랫덩이
        // 눈사람 키 차가 작아야함
        List<Snowman> snowmen = initSnowmen(arr);
        Collections.sort(snowmen);

        System.out.println(getMinDiff(snowmen));
    }

    // O(n^2)
    public static List<Snowman> initSnowmen(int[] snow) {
        List<Snowman> snowmen = new ArrayList<>();
        for (int i = 0; i < snow.length - 1; i++) {
            for (int j = i + 1; j < snow.length; j++) {
                snowmen.add(new Snowman(i, j, snow[i] + snow[j]));
            }
        }

        return snowmen;
    }

    // O(n)
    // 키 순으로 정렬된 눈사람이기 떄문에 연속한 눈사람의 차만 비교
    public static int getMinDiff(List<Snowman> snowmen) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < snowmen.size() - 1; i++) {
            Snowman snowman1 = snowmen.get(i);
            Snowman snowman2 = snowmen.get(i + 1);

            int upIdx1 = snowman1.upIdx;
            int downIdx1 = snowman1.downIdx;
            int upIdx2 = snowman2.upIdx;
            int downIdx2 = snowman2.downIdx;

            // 눈사람 만들때 사용한 눈덩이가 겹치지 않을 때 높이 차 계산
            if (upIdx1 != upIdx2 && upIdx1 != downIdx2 && downIdx1 != upIdx2 && downIdx1 != downIdx2) {
                min = Math.min(min, snowman2.height - snowman1.height);
            }
        }
        return min;
    }
}

class Snowman implements Comparable<Snowman> {
    int upIdx;
    int downIdx;
    int height;

    public Snowman(int upIdx, int downIdx, int height) {
        this.upIdx = upIdx;
        this.downIdx = downIdx;
        this.height = height;
    }

    // 키 기준 정렬
    @Override
    public int compareTo(Snowman o) {
        return this.height - o.height;
    }
}