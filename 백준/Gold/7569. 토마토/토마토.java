import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    상자의 가로, 세로, 높이 : M N H
    1 : 익은 토마토
    0 : 익지 않는 토마토
    -1 : 토마토 없음

    [ 출력 ]
    0 : 모두 익은 상황
    -1 : 모두 익지 못하는 상황
    max : 최소 며칠 걸렸는지
 */
public class Main {

    static int[][] board;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int[] mx = { 0, 0, 1, -1};
    static int[] my = { 1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        board = new int[N*H][M];
        visited = new boolean[N*H][M];
        queue = new LinkedList<>();
        boolean flag = false;

        for(int i=0;i<N*H;i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=0;j<M;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1)
                    setQueue(i,j);
                else if (board[i][j] == 0)
                    flag = true;
            }
        }

        solve(M, N, H);
        int max = Integer.MIN_VALUE;
//        for (int i=0;i<N*H;i++) {
//            for(int j=0;j<M;j++)
//                System.out.print(board[i][j] + " ");
//            System.out.println();
//        }

        for(int i=0;i<N*H;i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
                max = Math.max(max, board[i][j]);
            }
        }
        if (max==1 && !flag)
            System.out.println("0");
        else
            System.out.println(max-1);

    }

    private static void setQueue(int x, int y) {
        queue.add(new int[] {x,y});
        visited[x][y] = true;
    }

    private static void solve(int M, int N, int H) {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int height=now[0]/N+1;

            // 위층
            int upper = now[0] + N;
            int lower = now[0] - N;
            if (upper < N*H && !visited[upper][now[1]] && board[upper][now[1]]==0) {
                setQueue(upper, now[1]);
                board[upper][now[1]] = board[now[0]][now[1]] + 1;
            }

            // 아래층
            if (lower > -1 && !visited[lower][now[1]] && board[lower][now[1]]==0) {
                setQueue(lower, now[1]);
                board[lower][now[1]] = board[now[0]][now[1]] + 1;
            }

            // 상하좌우
            for(int i=0;i<4;i++) {
                int nextX = now[0] + mx[i];
                int nextY = now[1] + my[i];

                if (nextX < N*(height-1) || nextY < 0 || nextX > height*N-1 || nextY > M-1 || visited[nextX][nextY])
                    continue;
                if (board[nextX][nextY]==0) {
                    setQueue(nextX, nextY);
                    board[nextX][nextY] = board[now[0]][now[1]] + 1;
                }
            }
        }
    }
}
