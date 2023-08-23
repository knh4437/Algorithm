import java.util.Scanner;

// 백준 2750 - 수 정렬하기, 삽입 정렬로 구현 : https://www.acmicpc.net/problem/2750
public class BaekJoon2750_insertion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] list = new int[N];
        for (int i=0;i<N;i++) {
            list[i] = sc.nextInt();
        }

        for (int i=1;i<list.length;i++) {
            int key = list[i];
            // i = 기준 인덱스
            int j = i-1;
            // j = 비교 인덱스
            while (j>=0 && key < list[j]) {
                list[j+1] = list[j];
                // 이전 원소를 한 칸씩 오른쪽으로 미룬다.
                j--;
            }
            list[j+1] = key;
        }

        for(int i=0;i<N;i++)
            System.out.println(list[i]);
    }
}
