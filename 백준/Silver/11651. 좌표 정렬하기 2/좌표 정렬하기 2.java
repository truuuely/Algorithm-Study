import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Coordinate> coords = new ArrayList<>();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Coordinate coordinate = new Coordinate(x, y);
            coords.add(coordinate);
        }

        Collections.sort(coords);
        StringBuilder sb = new StringBuilder();
        for (Coordinate c : coords) {
            sb.append(c.x).append(" ").append(c.y).append("\n");
        }

        System.out.println(sb);
    }
}

class Coordinate implements Comparable<Coordinate> {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coordinate o) {
        return this.y == o.y ? this.x - o.x : this.y - o.y;
    }
}
