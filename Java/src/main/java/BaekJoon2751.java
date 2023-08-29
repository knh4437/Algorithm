import java.io.*;
import java.util.StringTokenizer;

// 백준 2751 - 수 정렬하기 2 : https://www.acmicpc.net/problem/2751
public class BaekJoon2751 {

    static int[] A, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        A = new int[N+1];
        tmp = new int[N+1];
        for(int i=1;i<N+1;i++)
            A[i] = Integer.parseInt(bf.readLine());

        merge_sort(1, N);
        for (int i=1;i<N+1;i++)
            bw.write(A[i] + "\n");
        bw.flush();
        bw.close();
    }

    static void merge_sort(int s, int e) {
        if (e-s < 1) return;
        int m = (s+e) / 2;  // 중간값

        merge_sort(s, m);
        merge_sort(m+1, e);

        for(int i=s;i<=e;i++) {
            tmp[i] = A[i];
        }
        int index1 = s;     // 왼쪽 부분 배열의 시작점
        int index2 = m+1;   // 오른쪽 부분 배열의 시작점
        int k = s;  // 채워넣을 배열의 인덱스

        while (index1 <= m && index2 <= e) {
            // 왼쪽 부분 배열 끝까지 가거나 오른쪽 부분 배열 끝까지 갈 때까지 반복
            if (tmp[index1] > tmp[index2]) {
                // 앞 데이터가 더 작을 경우
                A[k] = tmp[index2];
                // 값 변경
                index2++;
                // 포인터 뒤로 넘기기
            } else {
                A[k] = tmp[index1];
                index1++;
            }
            k++;
            // 배열을 채웠기 때문에 뒤로 넘기기
        }

        // 남아 있는 데이터 정리
//        while (index1 <= m) {
//            A[k] = tmp[index1];
//            k++;
//            index1++;
//        }
//
//        while(index2 <= e) {
//            A[k] =tmp[index2];
//            k++;
//            index2++;
//        }

        //
        for (int i=0;i<=m-index1;i++) {
            A[k+i] = tmp[index1+i];
        }
    }
}
