import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b=0;
        int big = 0;
        for (int i=0;i<9;i++) {
            a = sc.nextInt();
            if (a > big) {
                big = a;
                b = i;
            }
        }
        System.out.println(big);
        System.out.println(b+1);
    }
}
