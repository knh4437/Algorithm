import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SWEA2071 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++) {
            long sum = 0;
            for(int i=0;i<10;i++) {
                sum += sc.nextInt();
            }
            double result = (double)sum/10;
            bw.write("#" + test_case + " " + Math.round(result) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
