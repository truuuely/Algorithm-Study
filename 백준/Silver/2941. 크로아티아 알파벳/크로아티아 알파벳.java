import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        while(true) {
            if (st.contains("dz=")) {
                st = st.replace("dz=", "1");
            }
            else if (st.contains("c=")) {
                st = st.replace("c=", "1");
            }
            else if (st.contains("c-")) {
                st = st.replace("c-", "1");
            }
            else if (st.contains("d-")) {
                st = st.replace("d-", "1");
            }
            else if (st.contains("lj")) {
                st = st.replace("lj", "1");
            }
            else if (st.contains("nj")) {
                st = st.replace("nj", "1");
            }
            else if (st.contains("s=")) {
                st = st.replace("s=", "1");
            }
            else if (st.contains("z=")) {
                st = st.replace("z=", "1");
            }
            else {
                break;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(st.length()));
        bw.flush();
        bw.close();
    }
}