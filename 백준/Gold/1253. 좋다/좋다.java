import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 - '좋은 수' 구하기 : https://www.acmicpc.net/problem/1253
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long A[] = new long[N];
        int count = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i=0;i<N;i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);

        for(int i=0;i<N;i++) {
            long K = A[i];
            int start=0;
            int end=N-1;
            while (start < end) {
                if (A[start] + A[end] == K) {
                    if (start != i && end != i) {
                        count++;
                        break;
                    } else if (start == i)
                        start++;
                    else if (end == i)
                        end--;
                } else if (A[start] + A[end] < K)
                    start++;
                else
                    end--;
            }
        }
        System.out.println(count);
    }
}
