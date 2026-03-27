import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();

        PriorityQueue<Homework> pq = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);
        for (String[] p : plans) {
            pq.add(new Homework(p[0], p[1], p[2]));
        }

        Stack<Homework> stopStack = new Stack<>();

        while (!pq.isEmpty()) {
            Homework cur = pq.poll();
            int currentTime = cur.start;

            if (!pq.isEmpty()) { // 다음 과제 있으면
                Homework next = pq.peek();

                // 현재 과제를 다음 과제 시작 전까지 다 할 수 있는지 확인
                if (currentTime + cur.duration <= next.start) {
                    answer.add(cur.name);
                    currentTime += cur.duration;

                    // 시간이 남는다면 스택에서 멈춘 과제 꺼내서 하기
                    while (!stopStack.isEmpty()) {
                        Homework stopped = stopStack.pop();

                        if (currentTime + stopped.duration <= next.start) {
                            answer.add(stopped.name);
                            currentTime += stopped.duration;
                        } else {
                            // 또 다 못 끝내면 남은 시간만 깎고 다시 스택으로
                            stopped.duration -= (next.start - currentTime);
                            stopStack.push(stopped);
                            break;
                        }
                    }
                } else {
                    // 시간이 부족하면 남은 시간 계산해서 스택에 넣기
                    cur.duration -= (next.start - currentTime);
                    stopStack.push(cur);
                }
            } else {
                // 마지막 새 과제는 무조건 끝남
                answer.add(cur.name);
            }
        }

        // 3. 더 이상 새로 시작할 과제가 없으면 스택에 남은 것들 순서대로 끝내기
        while (!stopStack.isEmpty()) {
            answer.add(stopStack.pop().name);
        }

        return answer.toArray(new String[0]);
    }

    static class Homework {
        String name;
        int start, duration;

        public Homework(String name, String startStr, String durationStr) {
            this.name = name;
            String[] time = startStr.split(":");
            this.start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            this.duration = Integer.parseInt(durationStr);
        }
    }
}