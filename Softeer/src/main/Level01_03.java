// 주행거리 비교하기 - https://softeer.ai/practice/info.do?idx=1&eid=1016
import java.util.Scanner;
public class Level01_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String result = "same";
        if (a > b)
            result = "A";
        else if (a < b)
            result = "B";
        System.out.println(result);
    }
}
