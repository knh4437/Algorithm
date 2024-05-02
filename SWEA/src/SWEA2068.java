import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;


public class SWEA2068 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++) {
            int[] list = new int[10];
            for(int i=0;i<10;i++) {
                list[i] = sc.nextInt();
            }
            Arrays.sort(list);
            bw.write("#" + test_case + " " +list[9]+ "\n");
        }
        bw.flush();
        bw.close();
    }
}
