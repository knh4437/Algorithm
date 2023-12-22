import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1517 - 버블 소트 : https://www.acmicpc.net/problem/1517
public class BaekJoon1517 {

    static int[] A, tmp;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        A = new int[N+1];
        tmp = new int[N+1];
        result = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(1, N);
        System.out.println(result);
    }

    private static void merge_sort(int s, int e) {
        if (e-s < 1)
            return;
        int m = s+(e-s) / 2;

        merge_sort(s,m);
        merge_sort(m+1,e);

        int index1 = s;
        int index2 = m+1;
        int k = s;

        for(int i=s;i<=e;i++)
            tmp[i] = A[i];

        while (index1 <= m && index2 <= e) {
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                result+=index2-k;
                index2++;
            } else {
                A[k] = tmp[index1];
                // 앞쪽 데이터 값이 뒤로 가는 경우의 result 값은 계산해선 안 된다.
                index1++;
            }
            k++;
        }

        // 남아 있는 데이터 정리
        while (index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }

        while(index2 <= e) {
            A[k] =tmp[index2];
            k++;
            index2++;
        }

    }
}
