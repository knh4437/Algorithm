import java.util.Scanner;

// 백준 1427번 - 소트인사이드 : https://www.acmicpc.net/problem/1427
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int[] A = new int[input.length()];
        for (int i=0;i<A.length;i++) {
            A[i] = Integer.parseInt(input.substring(i, i+1));
        }
        for (int i=0;i<A.length;i++) {
            int max = i;
            for (int j=i+1;j<A.length;j++) {
                if (A[max] < A[j])
                    max = j;
            }
            // 최대값 찾기

            if (max != i) {
                int temp = A[max];
                A[max] = A[i];
                A[i] = temp;
            }
            // 최대값이 현재 값과 다르다면, swap 수행
        }
        for(int i=0;i<A.length;i++) {
            System.out.print(A[i]);
        }
    }
}
