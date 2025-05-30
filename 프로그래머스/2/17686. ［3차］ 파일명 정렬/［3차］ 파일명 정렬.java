import java.util.Arrays;


class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String o1Header = getHead(o1);
            String o2Header = getHead(o2);
            int headResult = o1Header.compareTo(o2Header);
            if (headResult == 0) { // head의 정렬이 동일한 경우
                // number 부분 비교
                return getNumber(o1, o1Header.length()) - getNumber(o2, o2Header.length());
            }

            return headResult;
        });
        return files;
    }

    private String getHead(String filename) {
        String[] heads = filename.split("\\d{1,5}", 2); // "1개 이상 5개 이하의 숫자"를 구분자로 하여 2개로 분리
        return heads[0].toLowerCase();
    }

    private Integer getNumber(String filename, int numIdx) {
        StringBuilder sb = new StringBuilder();
        for (int i = numIdx; i < filename.length(); i++) {
            char c = filename.charAt(i);
            if (Character.isDigit(c) && sb.length() <= 5) {
                sb.append(c);
            }
            else {
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}