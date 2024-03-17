import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] mx = {0,0,1,-1};
    static int[] my = {1, -1,0,0};
    static int N;
    static String[][] board;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(bf.readLine());
        board=new String[N][N];
        for(int i=0;i<N;i++)
            board[i] = bf.readLine().split("");

        queue = new LinkedList<>();
        boolean flag = false;
        for (int k=0;k<2;k++) {
            flag = !flag;
            boolean[][] visited = new boolean[N][N];
            int[][] countBoard = new int[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (solve(countBoard, visited, i, j, count, flag))
                        count++;
                }
            }
            sb.append(count + " ");
        }

        System.out.print(sb);
    }

    private static boolean solve(int[][] countBoard, boolean[][] visited, int x, int y, int count, boolean flag) {
        if (visited[x][y])
            return false;
        queue.add(new int[] {x,y});
        countBoard[x][y] = count;
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] v = queue.poll();

            for(int i=0;i<4;i++) {
                int nextX = v[0] + mx[i];
                int nextY = v[1] + my[i];
                if (nextX < 0 || nextY < 0 || nextX > N-1 || nextY > N-1 || visited[nextX][nextY])
                    continue;

                if (flag) {
                    if (!board[v[0]][v[1]].equals(board[nextX][nextY]))
                        continue;
                }
                else {
                    if (board[v[0]][v[1]].equals("B") && !board[nextX][nextY].equals("B"))
                        continue;
                    else if (board[v[0]][v[1]].equals("R") && board[nextX][nextY].equals("B")) {
                        continue;
                    }
                    else if (board[v[0]][v[1]].equals("G") && board[nextX][nextY].equals("B"))
                        continue;
                }

                countBoard[nextX][nextY] = countBoard[v[0]][v[1]];
                queue.add(new int[] {nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }
        return true;
    }

}
