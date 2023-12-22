import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr = input.split(" ");
        int[] numArr = new int[arr.length];
        int index=0;
        for(String i : arr) {
            numArr[index] = Integer.parseInt(i);
            index++;
        }
        Arrays.sort(numArr);
        System.out.println(numArr[1]);
    }
}
