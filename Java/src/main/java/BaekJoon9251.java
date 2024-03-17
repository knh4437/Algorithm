import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BottomUp 방식 - DP
public class BaekJoon9251 {

    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] N = bf.readLine().toCharArray();
        char[] M = bf.readLine().toCharArray();
        dp = new int[N.length+1][M.length+1];
        for(int i=0;i<N.length;i++) {
            for (int j=0;j<M.length;j++)
                solve(N, M, i, j);
        }
        System.out.println(dp[N.length][M.length]);
    }

    private static void solve(char[] N, char[] M, int i, int j) {
        if (N[i] == M[j]) dp[i+1][j+1] = dp[i][j] + 1;
        else if (N[i] != M[j]) dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
    }
}
