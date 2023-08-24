import java.util.Scanner;

// 백준 11399 - ATM : https://www.acmicpc.net/problem/11399
public class BaekJoon11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] list = new int[N];
        int[] S = new int[N+1];
        int sum = 0;
        for (int i=0;i<N;i++) {
            list[i] = sc.nextInt();
        }
        for (int i=1;i<N;i++) {
            int key = list[i];
            int j = i-1;
            while (j>=0 && key < list[j]) {
                list[j+1] = list[j];
                j--;
            }
            list[j+1] = key;
        }
        S[0] = list[0];
        for (int i=1;i<N;i++) {
            S[i] = S[i-1] + list[i];
        }
        // 합 배열
        for (int i=0;i<N;i++) {
            sum += S[i];
        }
        System.out.println(sum);
    }
}
