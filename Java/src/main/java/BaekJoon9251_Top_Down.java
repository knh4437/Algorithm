import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Top-Down
public class BaekJoon9251_Top_Down {

    private static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] N = bf.readLine().toCharArray();
        char[] M = bf.readLine().toCharArray();
        dp = new Integer[N.length][M.length];
        System.out.println(solve(N, M, N.length-1, M.length-1));
    }

    private static int solve(char[] N, char[] M, int x, int y) {
        if (x==-1 || y==-1) return 0;
        if (dp[x][y]==null) {
            dp[x][y] = 0;
            if (N[x] == M[y]) {
                dp[x][y] = solve(N, M, x - 1, y - 1) + 1;
            } else if (N[x] != M[y]) {
                dp[x][y] = Math.max(solve(N, M, x - 1, y), solve(N, M, x, y - 1));
            }
        }
        return dp[x][y];
    }
}
