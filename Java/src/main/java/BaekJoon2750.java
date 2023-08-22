import java.util.Scanner;

// 백준 2750 - 수 정렬하기 : https://www.acmicpc.net/problem/2750
public class BaekJoon2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] list = new int[N];
        for (int i=0;i<N;i++) {
            list[i] = sc.nextInt();
            if (i > 0 && list[i] > list[i-1]) {
                for (int j=i;j>0;j--) {

                }
            }
        }
    }
}
