import java.util.Scanner;

public class BaekJoon1735 {

    public static void main(String[] args) {

        int[] num = new int[4];
        int gcd;
        int deno, nume;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }
        deno = num[0]*num[3]+num[2]*num[1];
        nume = num[1]*num[3];
        gcd = GCD(deno, nume);
        System.out.println(deno/gcd + " " + nume/gcd);
    }
    public static int GCD(int a, int b){
        if (a%b == 0)
            return b;
        else
            return GCD(b,a%b);
    }
}
