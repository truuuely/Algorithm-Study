import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int recommendCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Student> map = new HashMap<>();

        for (int i = 0; i < recommendCount; i++) {
            int id = Integer.parseInt(st.nextToken());

            // 액자에 걸려있으면 추천수만 추가
            if (map.containsKey(id)) {
                Student student = map.get(id);
                student.recommendCount += 1;
            }

            // 안 걸려 있으면
            //  - 액자가 꽉 찼으면 기존 것 중 하나 삭제 후 게시
            //  - 액자 자리 있으면 추가
            else {
                if (map.size() == N) {
                    PriorityQueue<Student> pq = new PriorityQueue<>();
                    pq.addAll(map.values());
                    Student studentToRemove = pq.poll();
                    map.remove(studentToRemove.id);
                }

                map.put(id, new Student(id, 1, i));
            }
        }

        // 오름차순 출력
        List<Integer> ids = new ArrayList<>(map.keySet());
        Collections.sort(ids);
        StringBuilder sb = new StringBuilder();
        for (Integer id : ids) {
            sb.append(id).append(" ");
        }
        System.out.println(sb);
    }

    static class Student implements Comparable<Student> {
        int id;
        int recommendCount;
        int timestamp;

        public Student(int id, int recommendCount, int timestamp) {
            this.id = id;
            this.recommendCount = recommendCount;
            this.timestamp = timestamp;
        }

        @Override
        public int compareTo(Student o) {
            return  this.recommendCount == o.recommendCount ? this.timestamp - o.timestamp :
                    this.recommendCount - o.recommendCount;
        }
    }

}