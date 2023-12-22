import java.io.*;

// 백준 10989번 - 수 정렬하기 3 : https://www.acmicpc.net/problem/10989
public class Main {
    static int[] A;
    static long result;
    final static int MAX_SIZE = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        A = new int[N];
        for(int i=0;i<N;i++)
            A[i] = Integer.parseInt(bf.readLine());
        bf.close();
        radixSort();
        for(int i=0;i<N;i++)
            bw.write(A[i]+"\n");
        bw.flush();
        bw.close();
    }

    static void radixSort() {
        int[] output = new int[A.length];
        int digit = 1;
        int count = 0;
        while (count != MAX_SIZE) {
            // 최대 자릿수만큼 반봇
            int[] bucket = new int[10];     // 0 ~ 9 자릿수를 담는 배열
            for (int i=0;i<A.length;i++) {
                bucket[A[i]/digit % 10]++;
            }   // 각 자릿수별 갯수를 담는다.

            for (int i=1;i<bucket.length;i++) {
                bucket[i] += bucket[i-1];
            }   // 누적합

            for (int i=A.length-1;i>=0;i--) {
                int offset = A[i]/digit%10;
                output[bucket[offset]-1] = A[i];
                // 현재 자릿수을 기준으로 정렬
                bucket[offset]--;
            }

            for (int i=0;i<A.length;i++) {
                A[i] = output[i];
            }   // 다음 자릿수 계산을 위해 현재 자릿수 정렬 데이터 저장

            digit *= 10;
            count++;
        }

    }
}
