import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while(true) {
            s = bf.readLine();
            if (s == null)
                break;
            else {
                StringTokenizer st = new StringTokenizer(s);
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                if (A>0&&B<10)
                    System.out.println(A + B);
            }
        }
    }
}
