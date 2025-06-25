import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * TreeMap
 *
 * SortedMap의 구현체
 * HashMap과의 가장 큰 차이는 Map 객체에 있는 데이터가 자동 정렬됨
 *  기본 정렬 작업을 포함하고 있어서 HashMap 보다 성능이 상대적으로 떨어짐
 *  숫자, 문자 모두 오름차순으로 자동정렬
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 10만

        StringTokenizer st;

        TreeSet<Question> treeSet = new TreeSet<>(); // 난이도 오름차순 -> 문제 번호 오름차순
        Map<Integer, Question> map = new HashMap<>(); // 문제 삭제를 위한 맵
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            Question question = new Question(number, level);
            treeSet.add(question);
            map.put(number, question);
        }

        int m = Integer.parseInt(br.readLine()); // 명령문 개수
        for (int i = 0; i < m; i++) { // 1만
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "recommend":
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 1) {
                        // 내림차순 첫번째
                        System.out.println(treeSet.last().number);
                    } else {
                        // 오름차순 첫번째
                        System.out.println(treeSet.first().number);
                    }
                    break;
                case "add":
                    int number = Integer.parseInt(st.nextToken());
                    int level = Integer.parseInt(st.nextToken());
                    Question question = new Question(number, level);
                    treeSet.add(question);
                    map.put(number, question);
                    break;
                case "solved":
                    int num = Integer.parseInt(st.nextToken());
                    treeSet.remove(map.get(num));
            }

        }
    }

}

class Question implements Comparable<Question> {
    int number;
    int level;

    public Question(int number, int level) {
        this.number = number;
        this.level = level;
    }

    public Question(int number) {
        this(number, 0);
    }

    @Override
    public int compareTo(Question question) {
        return this.level == question.level ? this.number - question.number : this.level - question.level;
    }
}