import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    // 상하좌우
    static int[][] maze;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            String s = st.nextToken();
            for(int j=0;j<M;j++) {
                maze[i][j] = Integer.parseInt(s.substring(j,j+1));
            }
        }
        BFS(0,0);

        System.out.println(maze[N-1][M-1]);

    }
    static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i,j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for(int k=0;k<4;k++) {
                int nx = node[0] + dx[k];
                int ny = node[1] + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M)
                    if (!visited[nx][ny] && maze[nx][ny] != 0) {
                        visited[nx][ny] = true;
                        maze[nx][ny] = maze[node[0]][node[1]] + 1;
                        queue.add(new int[] {nx,ny});
                    }
            }
        }
    }
}
