import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

// 백준 2178 : 미로 찾기 - https://www.acmicpc.net/problem/2178
public class BaekJoon2178 {
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[N][M];
        int[][] graph = new int[N][M];

        for(int i=0;i<N;i++) {
            String s = bf.readLine();
            graph[i] = Stream.of(s.split("")).mapToInt(Integer::parseInt).toArray();
        }

        BaekJoon2178 baekJoon2178 = new BaekJoon2178();
        baekJoon2178.bfs(graph, 0, 0, visited);
    }

    private void bfs(int[][] graph, int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] v = queue.poll();
            int nowX = v[0];
            int nowY = v[1];
            for (int i=0;i<dx.length;i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (nextX < 0 || nextY<0 || nextX>=N || nextY>=M || visited[nextX][nextY] || graph[nextX][nextY] == 0)
                    continue;
                queue.add(new int[] {nextX,nextY}); // 이동 좌표값 추가
                visited[nextX][nextY] = true;   // 방문처리
                graph[nextX][nextY] = graph[nowX][nowY] + 1;    // 거리 측정. 누적해서 측정한 거리 + 1
            }
        }
        System.out.println(graph[N-1][M-1]);
    }
}
