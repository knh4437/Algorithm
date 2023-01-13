// A+B https://softeer.ai/practice/info.do?idx=1&eid=362
import java.util.Scanner;
public class Level01_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        int a, b;
        for(int i=0;i<test_case;i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println("Case #" + (i+1) + ": " + (a+b));
        }
    }
}
