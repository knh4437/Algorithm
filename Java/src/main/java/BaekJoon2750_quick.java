import java.util.Scanner;

// 백준 2750 - 수 정렬하기, 퀵 정렬로 구현 : https://www.acmicpc.net/problem/2750
public class BaekJoon2750_quick {
    static int[] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        list = new int[N];
        for (int i=0;i<N;i++) {
            list[i] = sc.nextInt();
        }

        quickSort(list, 0, list.length-1);

        for(int i=0;i<N;i++)
            System.out.println(list[i]);
    }

    static void quickSort(int[] arr, int l, int r) {
        if (l<r) {
            int p = partition(arr, l, r);

            quickSort(arr, l, p-1);
            quickSort(arr, p+1, r);
        }
    }

    static int partition(int arr[], int l, int r) {
        int pivot = arr[r];     // 배열의 가장 오른쪽 값을 기준으로 지정
        int i = l-1;

        for (int j=l;j<=r-1;j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        return i+1;
    }
}
