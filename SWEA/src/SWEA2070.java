import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SWEA2070 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++) {
            bw.write("#"+test_case+ " ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a < b)
                bw.write("<" + "\n");
            else if (a > b)
                bw.write(">" + "\n");
            else bw.write("=" + "\n");
        }
        bw.flush();
        bw.close();
    }
}
