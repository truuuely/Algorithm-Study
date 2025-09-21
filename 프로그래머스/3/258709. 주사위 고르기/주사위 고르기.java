import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    // 클래스 멤버 변수로 선언하여 여러 메소드에서 접근 가능하도록 함
    private static int[][] dices;
    private static int maxWinCount = -1;
    private static int[] answer;

    public static int[] solution(int[][] dice) {
        dices = dice;
        int n = dice.length;
        answer = new int[n / 2];

        // 0번 주사위부터 시작하여 n/2개의 주사위를 고르는 조합을 탐색
        selectDiceCombinations(0, new ArrayList<>());

        return answer;
    }

    /**
     * A가 가질 주사위 조합을 재귀적으로 선택하는 메소드
     * @param start 현재 선택할 주사위의 시작 인덱스
     * @param aDiceIndices A가 선택한 주사위들의 인덱스를 담는 리스트
     */
    private static void selectDiceCombinations(int start, ArrayList<Integer> aDiceIndices) {
        // A가 n/2개의 주사위를 모두 골랐을 때
        if (aDiceIndices.size() == dices.length / 2) {
            // B가 가질 주사위 리스트 생성
            ArrayList<Integer> bDiceIndices = new ArrayList<>();
            for (int i = 0; i < dices.length; i++) {
                if (!aDiceIndices.contains(i)) {
                    bDiceIndices.add(i);
                }
            }

            // 각 조합의 모든 합계 경우의 수 계산
            ArrayList<Integer> aSums = new ArrayList<>();
            calculateAllSums(aSums, aDiceIndices, 0, 0);

            ArrayList<Integer> bSums = new ArrayList<>();
            calculateAllSums(bSums, bDiceIndices, 0, 0);

            // 효율적인 비교를 위해 각 합계 리스트를 정렬
            Collections.sort(aSums);
            Collections.sort(bSums);

            // A가 이기는 경우의 수 계산
            int currentWinCount = countWins(aSums, bSums);

            // 최대 승리 횟수 갱신 및 정답 업데이트
            if (currentWinCount > maxWinCount) {
                maxWinCount = currentWinCount;
                for (int i = 0; i < aDiceIndices.size(); i++) {
                    // 주사위 번호는 1부터 시작하므로 +1
                    answer[i] = aDiceIndices.get(i) + 1;
                }
            }
            return;
        }

        // 백트래킹을 이용한 조합 생성
        for (int i = start; i < dices.length; i++) {
            aDiceIndices.add(i);
            selectDiceCombinations(i + 1, aDiceIndices);
            aDiceIndices.remove(aDiceIndices.size() - 1); // 마지막에 추가한 원소 제거 (백트래킹)
        }
    }

    /**
     * 선택된 주사위들로 나올 수 있는 모든 합계를 계산하여 리스트에 추가하는 메소드
     * @param sumList 합계를 저장할 리스트
     * @param selectedIndices 선택된 주사위들의 인덱스 리스트
     * @param depth 현재 고려 중인 주사위의 깊이 (selectedIndices 내에서의 인덱스)
     * @param currentSum 현재까지의 합계
     */
    private static void calculateAllSums(ArrayList<Integer> sumList, ArrayList<Integer> selectedIndices, int depth, int currentSum) {
        // 모든 주사위를 다 사용했을 때
        if (depth == selectedIndices.size()) {
            sumList.add(currentSum);
            return;
        }

        int diceIndex = selectedIndices.get(depth); // 실제 주사위 번호를 가져옴 (버그 수정)
        // 해당 주사위의 각 면에 대해 재귀 호출
        for (int faceValue : dices[diceIndex]) {
            calculateAllSums(sumList, selectedIndices, depth + 1, currentSum + faceValue);
        }
    }

    /**
     * A의 합계 리스트와 B의 합계 리스트를 비교하여 A가 이기는 총 경우의 수를 계산하는 메소드
     * @param aSums A의 모든 합계 (정렬된 상태)
     * @param bSums B의 모든 합계 (정렬된 상태)
     * @return A가 이기는 총 횟수
     */
    private static int countWins(ArrayList<Integer> aSums, ArrayList<Integer> bSums) {
        int totalWins = 0;

        // A의 각 합계에 대해
        for (int sumA : aSums) {
            // 이진 탐색으로 sumA보다 작은 값이 bSums에 몇 개 있는지 찾는다.
            int low = 0;
            int high = bSums.size() - 1;
            int count = 0; // sumA보다 작은 원소의 개수

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (bSums.get(mid) < sumA) {
                    // 중간값이 sumA보다 작으면, 해당 지점까지는 모두 이기는 경우임
                    // 더 큰 값도 있을 수 있으므로 오른쪽 부분을 탐색
                    count = mid + 1;
                    low = mid + 1;
                } else {
                    // 중간값이 sumA보다 크거나 같으면, 왼쪽 부분을 탐색
                    high = mid - 1;
                }
            }
            totalWins += count; // 찾은 개수를 총 승리 횟수에 더함
        }
        return totalWins;
    }
}