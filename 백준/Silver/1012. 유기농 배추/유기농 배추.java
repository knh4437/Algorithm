import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bf;
    static int[] mx = { 0, 0, 1, -1 };
    static int[] my = { 1, -1, 0, 0 };
    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for(int i=0;i<T;i++) {
            sb.append(testcase() + "\n");
        }
        System.out.print(sb);
    }

    private static int testcase() throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] board = new int[M][N];
        boolean[][] visited = new boolean[M][N];
        int count = 0;
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b]++;
        }

        for(int i=0;i<M;i++)
            for(int j=0;j<N;j++) {
                if (board[i][j]==1 && !visited[i][j]) {
                    count++;
                    bfs(board, visited, M-1, N-1, i, j);
                }
            }
        return count;
    }

    private static void bfs(int[][] board, boolean[][] visited, int M, int N, int x, int y) {
        visited[x][y] = true;
        if (x == M && y == N)
            return;

        for(int i=0;i<4;i++) {
            int moveX = x+mx[i];
            int moveY = y+my[i];
            if (moveX < 0 || moveY < 0 || moveX > M || moveY > N || visited[moveX][moveY] || board[moveX][moveY] == 0)
                continue;
            bfs(board, visited, M, N, moveX, moveY);
        }
    }
}
