import java.util.Scanner;

public class BaekJoon2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        for (int i=0;i<5;i++) {
            answer += Math.pow(sc.nextInt(), 2);
        }
        System.out.println(answer%10);
    }
}
