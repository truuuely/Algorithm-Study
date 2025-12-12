public class Main {
    public static void main(String[] args) {
        int N = 100;
        int M = N - 1;

        StringBuilder sb = new StringBuilder();
        sb.append(N).append(" ").append(M).append("\n");

        for (int i = N - 1; i >= 1; i--) {
            sb.append(i).append(" ").append(i + 1).append(" -1\n");
        }

        System.out.println(sb);
    }
}