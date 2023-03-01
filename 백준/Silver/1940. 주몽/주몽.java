import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 1940번 - 주몽 : https://www.acmicpc.net/problem/1940
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        long[] arr = new long[N];
        int start = 0;
        int end = N-1;
        int ans=0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        while (start!=end) {
            long hap = arr[start] + arr[end];
            if (hap > M)
                end--;
            else if (hap < M)
                start++;
            else {
                ans++;
                end--;
            }
        }
        System.out.println(ans);
    }
}
