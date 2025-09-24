import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long sum1 = 0, sum2 = 0;
        for (int i : queue1) {
            sum1 += i;
        }
        for (int i : queue2) {
            sum2 += i;
        }

        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }

        ArrayDeque<Integer> q1 = new ArrayDeque<>(Arrays.stream(queue1).boxed().collect(Collectors.toList()));
        ArrayDeque<Integer> q2 = new ArrayDeque<>(Arrays.stream(queue2).boxed().collect(Collectors.toList()));

        int limit = (queue1.length + queue2.length) * 2;
        while (sum1 != sum2) {
            if (sum1 > sum2) {
                int poll = q1.poll();
                sum1 -= poll;
                sum2 += poll;
                q2.add(poll);
            } else {
                int poll = q2.poll();
                sum2 -= poll;
                sum1 += poll;
                q1.add(poll);
            }

            answer += 1;
            if (answer > limit) {
                return -1;
            }
        }

        return answer;
    }
}
