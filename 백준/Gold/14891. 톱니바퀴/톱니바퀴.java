import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Integer>[] cogwheels = new ArrayList[4]; // N극: 0, S극: 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < cogwheels.length; i++) {
            cogwheels[i] = new ArrayList<>();

            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                int pole = str.charAt(j) - '0';
                cogwheels[i].add(pole);
            }
        }

        int K = Integer.parseInt(br.readLine()); // 회전 횟수
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int wheelNum = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken()); // 1: 시계, -1: 반시계

            int[] rotateDir = new int[4];
            determineRotation(wheelNum, direction, rotateDir); // 결정방향을 정하고 나중에 한번에 회전해야됨

            for (int j = 0; j < 4; j++) {
                rotate(j, rotateDir[j]);
            }
        }

        // 점수 계산
        int score = 0;
        for (int i = 0; i < cogwheels.length; i++) {
            score += (int) (cogwheels[i].get(0) * Math.pow(2, i));
        }

        System.out.println(score);
    }

    private static void determineRotation(int curWheelIdx, int direction, int[] rotateDir) {
        rotateDir[curWheelIdx] = direction;

        int leftNeighbor = curWheelIdx - 1;
        if (validWheel(leftNeighbor) && rotateDir[leftNeighbor] == 0) {
            if (!cogwheels[curWheelIdx].get(6).equals(cogwheels[leftNeighbor].get(2))) {
                determineRotation(leftNeighbor, -direction, rotateDir);
            }
        }

        int rightNeighbor = curWheelIdx + 1;
        if (validWheel(rightNeighbor) && rotateDir[rightNeighbor] == 0) {
            if (!cogwheels[curWheelIdx].get(2).equals(cogwheels[rightNeighbor].get(6))) {
                determineRotation(rightNeighbor, -direction, rotateDir);
            }
        }
    }

    private static void rotate(int wheelNum, int direction) {
        if (direction == 1) { // 시계
            cogwheels[wheelNum].add(0, cogwheels[wheelNum].remove(7));
        } else if (direction == -1) { // 반시계
            cogwheels[wheelNum].add(7, cogwheels[wheelNum].remove(0));
        }
    }

    private static boolean validWheel(int wheelNum) {
        return wheelNum >= 0 && wheelNum < 4;
    }

}