import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String answer="";
        if ((num<=100)&&(num>=90))
            answer = "A";
        else if ((num<=89)&&(num>=80))
            answer = "B";
        else if ((num<=79)&&(num>=70))
            answer = "C";
        else if ((num<=69)&&(num>=60))
            answer ="D";
        else
            answer ="F";
        System.out.println(answer);
    }
}
