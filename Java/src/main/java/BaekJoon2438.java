import java.util.Scanner;

public class BaekJoon2438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String star = "*";
        for (int i=0;i<num;i++) {
            System.out.println(star);
            star += "*";
        }
    }
}
