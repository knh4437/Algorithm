import java.util.Scanner;

public class BaekJoon2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());

        int q = b / 10; // 47
        int one = b % 10; // 2
        int ten = q % 10; // 7
        int hundred = q / 10; // 4

        System.out.println(a*one);
        System.out.println(a*ten);
        System.out.println(a*hundred);
        System.out.println(a*b);
    }
}
