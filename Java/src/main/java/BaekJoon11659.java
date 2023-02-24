import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11659번 - 구간 합 구하기 4 : https://www.acmicpc.net/problem/11659
public class BaekJoon11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] S = new int[N+1]; // 구간 합 배열
        st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=N;i++) {
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(S[b]-S[a-1]);
        }
    }
}
