import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    백트래킹과 DFS
 */
public class BaekJoon14500 {
    static int[][] board;
    static boolean[][] visited;
    static int N, M;
    static int max = Integer.MIN_VALUE;
    static int[] mx = { 0,0,1,-1};
    static int[] my = { 1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                visited[i][j] = true;
                dfs(i,j, board[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.print(max);
    }

    private static void dfs(int x, int y, int result, int count) {
        if (count==4) {
            max = Math.max(result, max);
            return;
        }

        for(int i=0;i<4;i++) {
            int nextX = x + mx[i];
            int nextY = y + my[i];
            if (nextX < 0 || nextY < 0 || nextX > N-1 || nextY > M-1 || visited[nextX][nextY])
                continue;
            if (count == 2) {
                visited[nextX][nextY] = true;
                dfs(x,y,result+board[nextX][nextY], count+1);
                visited[nextX][nextY] = false;
            }
            visited[nextX][nextY] = true;
            dfs(nextX, nextY, result+board[nextX][nextY], count+1);
            visited[nextX][nextY] = false;
        }
    }

}
