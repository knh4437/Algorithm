import java.util.Scanner;

// 백준 2750 - 수 정렬하기 : https://www.acmicpc.net/problem/2750
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] list = new int[N];
        for (int i=0;i<N;i++) {
            list[i] = sc.nextInt();
        }

        for(int i=0;i<N-1;i++) {
            for (int j=0;j<N-1-i;j++) {
                if (list[j] > list[j+1]) {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }

        for(int i=0;i<N;i++)
            System.out.println(list[i]);
    }
}
