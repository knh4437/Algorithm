import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[][] board;
    static int N,M;
    static int[] mx = {0,0,1,-1};
    static int[] my = {1,-1,0,0};
    static ArrayList<Integer> list;
    
    public ArrayList<Integer> solution(String[] maps) {
        int[] answer = {};
        N = maps.length;
        M = maps[0].length();
        board = new int[N][M];
        list = new ArrayList<>();
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                char c = maps[i].charAt(j);
                if (c == 'X') board[i][j] = -1;
                else board[i][j] = c -'0';
            }    
        }
        
        int result = 0;
        
        for(int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (board[i][j] != -1) {
                    result = dfs(i,j, result);
                    list.add(result);
                    result = 0;
                }
            }
        }
        
        if (list.size() == 0)
            list.add(-1);
        
        Collections.sort(list);
        
        return list;
    }
    
    private static int dfs(int x, int y, int result) {
        result += board[x][y];
        board[x][y] = -1;
        for(int i=0;i<4;i++) {
            int nx = x + mx[i];
            int ny = y + my[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                continue;
            if (board[nx][ny]==-1)
                continue;
            result = dfs(nx,ny,result);
        }
        return result;
    }
}