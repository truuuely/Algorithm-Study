import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 전공평점 = (학점 * 과목평점 + 학점 * 과목평점 + ....) / 학점의 총합

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        float totalScore = 0f; // 학점 * 과목평점 + ...
        float sumOfCredits = 0f; // 학점총합
        for (int i = 0; i < 20; i++) {
            String s = br.readLine();
            String[] eachLine = s.split(" ");

            if (!eachLine[2].equals("P")) {
                float credit = Float.parseFloat(eachLine[1]); // 학점
                float score = getScoreFromGrade(eachLine[2]); // 과목평점
                totalScore += credit * score;
                sumOfCredits += credit;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(totalScore/sumOfCredits));
        bw.flush();
        bw.close();
    }

    private static float getScoreFromGrade(String grade) {
        float score = 0f;
        if (grade.contains("A")) {
            score = 4f;
        } else if (grade.contains("B")) {
            score = 3f;
        } else if (grade.contains("C")) {
            score = 2f;
        } else if (grade.contains("D")) {
            score = 1f;
        }

        if (grade.contains("+")) {
            score += 0.5f;
        }

        return score;
    }
}