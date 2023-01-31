import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

// 백준 7576번 : 토마토 - https://www.acmicpc.net/problem/7576
public class BeakJoon7576 {
    int[] dx = { 1, 0, -1, 0 };
    int[] dy = { 0, 1, 0, -1 };
    static int N, M;
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[M][N];
        for (int i=0;i<M;i++) {
            String s = bf.readLine();
            graph[i] = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        BeakJoon7576 beakJoon7576 = new BeakJoon7576();
        visited = new boolean[M][N];
        beakJoon7576.findStart(graph);  // 값이 1인 인덱스들을 사전에 큐에 삽입
        beakJoon7576.bfs(graph);
    }

    private void findStart(int[][] graph) {
        for (int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j}); // 큐 삽입
                    visited[i][j] = true;   // 방문 처리
                }
            }
        }
    }

    private void bfs(int[][] graph) {
        ans = -1;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            for (int i=0;i<dx.length;i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || visited[nextX][nextY])
                    continue;
                if (graph[nextX][nextY] == 0) {
                    ans = 0;
                    visited[nextX][nextY] = true;
                    graph[nextX][nextY] = graph[nowX][nowY] + 1;
                    queue.add(new int[] { nextX, nextY });
                }
            }
        }
        findResult(graph);
        System.out.println(ans-1);
    }

    private void findResult(int[][] graph) {
        for (int i=0;i<M;i++) {
            for (int j=0;j<N;j++) {
                // 익지 않은 토마토가 있을 경우, 함수 종료
                if (graph[i][j] == 0) {
                    ans = -1;
                    break;
                }
                if (graph[i][j] > ans)
                    ans = graph[i][j];
            }
            // 익지 않은 토마토가 있을 경우, 함수 종료
            if (ans == -1)
                break;
        }
        if (ans == -1)
            ans = 0;
    }
}
