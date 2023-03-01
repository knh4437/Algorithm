import java.util.Scanner;

// 백준 2018번 - https://www.acmicpc.net/problem/2018
public class BaekJoon2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int sum = 1;
        int count = 1;
        int start_index = 1;
        int end_index = 1;

        while (end_index!=N) {
            if (sum > N) {
                sum-=start_index;
                start_index++;
            } else if (sum < N) {
                end_index++;
                sum+=end_index;
            } else {
                end_index++;
                sum+=end_index;
                count++;
            }
        }
        System.out.println(count);
    }
}
