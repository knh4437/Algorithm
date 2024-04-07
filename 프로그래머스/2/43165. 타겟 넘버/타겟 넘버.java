class Solution {
    static int result;
    static boolean[] visited;
    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        result = 0;
        dfs(numbers, target, 0, 0);
        return result;
    }
    
    private static void dfs(int[] numbers, int target, int cur, int index) {
        if (index == numbers.length) {
            if (cur == target) {
                result++;
            }
            return;
        }
        dfs(numbers,target,cur + numbers[index], index+1);
        dfs(numbers,target,cur - numbers[index], index+1);
    }
}