import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BaekJoon10818 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int input;
        int big = 0;
        int small = 0;
        boolean flag=false;
        for(int i=0;i<num;i++) {
            input = sc.nextInt();
            if (flag == false) {
                big = input;
                small = input;
                flag = true;
            }
            if (big <= input)
                big = input;
            else if (small >= input)
                small = input;
        }
        System.out.println(small+" "+big);
    }
}
