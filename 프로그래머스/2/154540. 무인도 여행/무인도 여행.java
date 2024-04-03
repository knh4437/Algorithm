import java.util.*;

class Solution {
    static int N, M;
    static int[][] board;
    
    public ArrayList<Integer> solution(String[] maps) {
        int[] answer = {};
        N = maps.length;
        M = maps[0].length();
        board = new int[N][M];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                char c = maps[i].charAt(j);
                if (c == 'X') board[i][j] = -1;
                else board[i][j] = c -'0';
            }    
        }
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if (board[i][j] != -1)
                    list.add(bfs(i,j));
            }
        }
        Collections.sort(list);
        if (list.size() == 0)
            list.add(-1);
        return list;
    }
    
    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        int sum = board[x][y];
        board[x][y]=-1;
        int[] mx = {0,0,1,-1};
        int[] my = {1,-1,0,0};
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int i=0;i<4;i++) {
                int nx = cur[0] + mx[i];
                int ny = cur[1] + my[i];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (board[nx][ny] == -1)
                    continue;
                queue.add(new int[]{nx,ny});
                sum += board[nx][ny];
                board[nx][ny] = -1;
            }
        }
        return sum;
    }
}