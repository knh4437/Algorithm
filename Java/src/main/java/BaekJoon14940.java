import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon14940 {
    static int[][] board;
    static boolean[][] visited;
    static int N,M;

    static int[] transX = { 0, 1, -1, 0};
    static int[] transY = { 1, 0, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        int startX=0,startY=0;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j]==2) {
                    startX = i;
                    startY = j;
                    board[i][j] = 0;
                }
            }
        }

        solve(startX, startY);

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if (board[i][j]==1 && (check(i,j, startX,startY)))
                    board[i][j] = -1;
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void solve(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] n = queue.poll();
            for(int k=0;k<4;k++) {
                int nextX = n[0] + transX[k];
                int nextY = n[1] + transY[k];
                if (nextX > N-1 || nextY > M-1 || nextX < 0 || nextY < 0 || visited[nextX][nextY] || board[nextX][nextY]==0)
                    continue;
                queue.add(new int[] {nextX, nextY});
                visited[nextX][nextY] = true;
                board[nextX][nextY] += board[n[0]][n[1]];
            }
        }
    }
    private static boolean check(int x, int y, int startX, int startY) {
        for(int i=0;i<4;i++) {
            if (x == startX + transX[i] && y == startY + transY[i])
                return false;
        }
        return true;
    }
}
