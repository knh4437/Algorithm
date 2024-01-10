import java.util.Scanner;
// DP의 하향식(Top-down)과 상향식(Bottom-top)을 이용하여 피보나치 함수 구현하기
public class DynamicProgramming {
    private static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        System.out.println("Top-Down : " + TopdownFibo(n));
        dp = new int[n+1];
        System.out.println("Bottom-up : " + BottomupFibo(n));

    }

    private static int TopdownFibo(int x) {
        if (x==1 || x==2) return 1;
        if (dp[x] !=0) return dp[x];
        // 재사용
        dp[x] = TopdownFibo(x-1) + TopdownFibo(x-2);

        return dp[x];
    }

    private static int BottomupFibo(int x) {
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3;i<x+1;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[x];
    }
}
