import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] arr;
    private static ArrayList<CCTV> cctvList;
    private static int min = Integer.MAX_VALUE;
    private static Map<Integer, List<Integer>> directionsPerCam;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        cctvList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] >= 1 && arr[i][j] <= 5) {
                    cctvList.add(new CCTV(i, j, arr[i][j], 0));
                }
            }
        }

        initMap();

        dfs(0, new ArrayList<>());
        System.out.println(min);
    }

    // 각 카메라가 확인할 수 있는 방향들
    private static void initMap() {
        directionsPerCam = new HashMap<>();
        directionsPerCam.put(1, Arrays.asList(1, 2, 4, 8));
        directionsPerCam.put(2, Arrays.asList(5, 10));
        directionsPerCam.put(3, Arrays.asList(3, 6, 9, 12));
        directionsPerCam.put(4, Arrays.asList(7, 11, 13, 14));
        directionsPerCam.put(5, List.of(15));
    }

    private static void dfs(int idx, List<CCTV> currentList) {
        // 카메라1의 방향 전체 중 하나 선택
        // 다음 카메라(카메라2)의 방향 또 선택
        // 전체 카메라의 방향 다 선택했으면? -> 사각지대 확인
        if (!valid(idx, 0, cctvList.size())) {
            // 사각지대 확인
            min = Math.min(min, getBlindSpotSize(currentList));
            return;
        }

        CCTV camera = cctvList.get(idx);
        List<Integer> dirList = directionsPerCam.get(camera.number); // 이 카메라가 볼 수 있는 방향 목록

        for (int i = 0; i < dirList.size(); i++) {
            currentList.add(new CCTV(camera.r, camera.c, camera.number, dirList.get(i)));
            dfs(idx + 1, currentList);
            currentList.remove(currentList.size() - 1);
        }
    }

    private static boolean valid(int target, int startIncluded, int endExcluded) {
        return target >= startIncluded && target < endExcluded;
    }

    private static int getBlindSpotSize(List<CCTV> currentList) {
        int[][] curBoard = new int[N][M];
        for (int i = 0; i < curBoard.length; i++) {
            curBoard[i] = Arrays.copyOf(arr[i], arr[i].length);
        }

        for (CCTV cctv : currentList) {
            // 방향에 맞게 영역 지우기
            monitoring(curBoard, cctv);
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (curBoard[i][j] == 0) { // 사각지대 카운트
                    res += 1;
                }
            }
        }

        return res;
    }

    private static final int[] dir = {8, 4, 2, 1}; // 북, 동, 남, 서
    private static final int[] dRow = {-1, 0, 1, 0}; // 북, 동, 남, 서
    private static final int[] dCol = {0, 1, 0, -1}; // 북, 동, 남, 서

    private static void monitoring(int[][] curBoard, CCTV cctv) {
        for (int i = 0; i < dir.length; i++) {
            // 이 CCTV가 해당 방향을 보는지 확인
            if ((cctv.bitmask & dir[i]) == dir[i]) {
                int nRow = cctv.r;
                int nCol = cctv.c;

                while (true) {
                    nRow += dRow[i];
                    nCol += dCol[i];

                    if (!valid(nRow, 0, N) || !valid(nCol, 0, M)
                            || curBoard[nRow][nCol] == 6) {
                        break;
                    }

                    if (curBoard[nRow][nCol] >= 1 && curBoard[nRow][nCol] <= 5) { // 다른 카메라인 경우
                        continue;
                    }

                    curBoard[nRow][nCol] = 10; // 문제 설명의 #을 그냥 10으로 표시
                }
            }
        }
    }

    static class CCTV {
        int r, c;
        int number;
        int bitmask; // 비트마스킹용

        public CCTV(int r, int c, int number, int bitmask) {
            this.r = r;
            this.c = c;
            this.number = number;
            this.bitmask = bitmask;
        }
    }
}