import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
public class SWEA2072 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("SWEA/static/2072.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            long sum = 0;
            for(int i=0;i<10;i++) {
                int num = sc.nextInt();
                if (num%2!=0)
                    sum += num;
            }
            bw.write("#"+test_case + " "+sum+"\n");
        }
        bw.flush();
        bw.close();
    }
}
