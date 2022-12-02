import java.util.HashMap;
import java.util.Scanner;

public class BaekJoon2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map =new HashMap<>();
        long num = 1;
        int a;
        for (int i=0;i<3;i++){
            num *= sc.nextInt();
        } // 17037300
        while (num >= 1) {
            a = (int)(num%10);  // 0 0 3 7 3 0 7 1
            if (!map.containsKey(a))
                map.put(a, 1);
            else
                map.put(a, map.get(a)+1);
            num /= 10;
        }
        for (int i=0;i<10;i++){
            if (!map.containsKey(i))
                System.out.println("0");
            else
                System.out.println(map.get(i));
        }
    }
}
