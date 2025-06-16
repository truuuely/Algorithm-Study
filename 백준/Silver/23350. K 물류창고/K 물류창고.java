import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 첫째 줄엔 컨테이너의 개수
 N과 우선순위의 종류
 M이 주어진다. (1 <= M <= N <= 100)

 2번째 줄부터
 N + 1번째 줄까지는 컨테이너들의 우선순위 P (1 <= P <= M),
 무게 W (1 <= W <= 100)가 순서대로 주어진다.

 레일에 배치되는 순서는 입력으로 주어지는 컨테이너의 순서와 동일하다.

 모든 입력은 1 이상의 정수이다.*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 컨테이너 개수
        int M = Integer.parseInt(st.nextToken()); // 우선순위 종류

        Queue<Container> queue = new LinkedList<>();
        int[] priorities = new int[M + 1]; // M에 가까운게 먼저 적재되어야 함
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pr = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            queue.add(new Container(pr, w));
            priorities[pr] += 1;
        }

        // 우선순위가 큰 거 먼저 적재
        // 우선순위가 같으면
        //      무거운 거 먼저 적재
        /**
         * 스택에 적재
         * 1. queue에서 컨테이너 꺼낸다
         * 2. 꺼낸 게 우선순위가 낮거나 같다?
         *      while (스택.peek 의 무게 < 현재 컨테이너 무게)
         *          스택.pop 해서.. 어딘가에 저장해놓음  + 각 컨테이너 무게
         *      현재 컨테이너 스택에 저장   +컨테이너 무게
         *      어딘가에 저장해놓은 컨테이너들을 스택에 다시 무게 순서대로 넣음  +각 컨테이너 무게
         * 3. 우선순위가 높다? (== 뒤에 우선순위가 낮은 것들이 있다)
         *      queue 에 다시 넣는다.  + 컨테이너 무게
         *
         * ** 우선순위 배열에서 x번째 -> 현재 컨테이너랑 비교해서
         *       현재 컨테이너 우선순위
         */

        Stack<Container> stack = new Stack<>();
        int total = 0;
        int priority = M;
        while (!queue.isEmpty()) {
            Container poll = queue.poll();

            if (priorities[priority] <= 0) {
                priority -= 1;
            }

            if (poll.priority == priority) { // 현재 우선순위
                ArrayList<Container> list = new ArrayList<>(); // 나머지 공간. 무게순으로 다시 적재하기 위해 리스트 사용

                // 동일 우선순위인 것들만 list 에 보관
                while (!stack.isEmpty() && stack.peek().priority == priority && stack.peek().weight < poll.weight) {
                    Container pop = stack.pop();
                    total += pop.weight * 2; // 뺐다가 + 다시 적재하는 무게까지
                    list.add(pop);
                }

                total += poll.weight;
                stack.push(poll);

                // 나머지 공간에 빼 놨던 것들은 순서대로 다시 적재
                list.sort((o1, o2) -> o2.weight - o1.weight);
                list.forEach(stack::push);

                priorities[priority] -= 1;
            } else {
                total += poll.weight;
                queue.add(poll);
            }
        }

        System.out.println(total);
    }
}

class Container {
    int priority;
    int weight;

    public Container(int priority, int weight) {
        this.priority = priority;
        this.weight = weight;
    }
}