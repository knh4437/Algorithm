class Solution {
    static int[] dp;
    
    private static int fibo(int n){
        if (n==1 || n==2) return 1;
        if (dp[n] != 0) return dp[n];
        dp[n] = (fibo(n-1) + fibo(n-2))%1234567;
        
        return dp[n];
    }
    
    public int solution(int n) {
        dp = new int[n+1];
        int answer = fibo(n);
        return answer;
    }
}