import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 10986번 - 나머지 합 : https://www.acmicpc.net/problem/10986
public class BaekJoon10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int count = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] S = new long[count+1];
        long[] C = new long[M];
        long ans = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i=1;i<=count;i++) {
            // M으로 나머지 연산을 수행한 합 배열 S
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
            long reminder = S[i] % M;
            if (reminder == 0)
                ans++;
            C[(int)reminder]++;
        }
        for (int i=0;i<M;i++) {
            if (C[i] > 1)
                ans+= C[i]*(C[i]-1)/2;
        }
        System.out.println(ans);
    }
}
