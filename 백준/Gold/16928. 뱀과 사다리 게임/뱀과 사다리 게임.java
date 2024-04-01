import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new int[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a] = b;
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int[] check = new int[101];
        check[1] = 0;
        // 횟수

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i=6;i>=1;i--) {
                int next = cur + i;
                if (next > 100)
                    continue;
                if (check[next]==0 && board[next]==0) {
                    queue.add(next);
                    check[next] = check[cur] + 1;
                }
                // 방문한 적이 없고, 사다리 및 뱀이 없는 칸일 경우

                else if (board[next] != 0) {
                    int move = board[next];
                    if (check[move] == 0) {
                        queue.add(move);
                        check[move] = check[cur] + 1;
                    }
                }
            }
        }
        System.out.println(check[100]);
    }


}
