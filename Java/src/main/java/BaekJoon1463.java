import java.io.*;


public class BaekJoon1463 {

    private static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());

        dp = new Integer[N+1];
        dp[0] = dp[1] = 0;
        bw.write(String.valueOf(solve(N)));
        bw.close();
    }

    private static int solve(int x) {
        if (dp[x] != null) return dp[x];

        if (x%6==0) {
            dp[x] = Math.min(Math.min(solve(x/3), solve(x/2)), solve(x-1)) +1;
        }

        else if (x%3==0) {
            dp[x] = Math.min(solve(x/3), solve(x-1)) +1;
        }

        else if (x%2==0) {
            dp[x] = Math.min(solve(x/2), solve(x-1)) +1;
        }

        else {
            dp[x] = solve(x-1) + 1;
        }
        return dp[x];
    }
}
