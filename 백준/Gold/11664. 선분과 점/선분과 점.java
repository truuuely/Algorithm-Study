import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Point A = new Point(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
        Point B = new Point(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
        Point C = new Point(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));

        double AB = Math.sqrt(Math.pow(A.x - B.x, 2.0) +
                Math.pow(A.y - B.y, 2.0) +
                Math.pow(A.z - B.z, 2.0));

        Point uAB = new Point((B.x - A.x) / AB, (B.y - A.y) / AB, (B.z - A.z) / AB);
        Point vectorAC = new Point(C.x - A.x, C.y - A.y, C.z - A.z);

        // AC와 uAB 내적 구하기 == |AC'|
        double innerProdAC = Math.abs(vectorAC.x * uAB.x + vectorAC.y * uAB.y + vectorAC.z * uAB.z);

        double BC = Math.sqrt(Math.pow(B.x - C.x, 2.0) +
                Math.pow(B.y - C.y, 2.0) +
                Math.pow(B.z - C.z, 2.0));

//        Point uBC = new Point((C.x - B.x) / BC, (C.y - B.y) / BC, (C.z - B.z) / BC);
        Point vectorBC = new Point(C.x - B.x, C.y - B.y, C.z - B.z);
        double innerProdBC = Math.abs(vectorBC.x * uAB.x + vectorBC.y * uAB.y + vectorBC.z * uAB.z); // |BC'|

        double CC = Math.sqrt(Math.abs(Math.pow(vectorAC.x, 2.0) + Math.pow(vectorAC.y, 2.0) + Math.pow(vectorAC.z, 2.0) - Math.pow(innerProdAC, 2.0))); // CC'

        double ans = CC;

        // AC' > AB || BC' > AB
        //  -> min(AC, BC)
        if (innerProdAC > AB || innerProdBC > AB) {
            double AC = Math.sqrt(Math.pow(vectorAC.x, 2.0) + Math.pow(vectorAC.y, 2.0) + Math.pow(vectorAC.z, 2.0));
            ans = Math.min(AC, BC);
        }

        System.out.printf("%.6f", ans);
    }

    static class Point {
        double x, y, z;

        public Point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}