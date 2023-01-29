import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1260번 - DFS와 BFS : https://www.acmicpc.net/problem/1260
public class BaekJoon1260 {

    static int node, line, point;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        point = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[node+1];
        int[][] graph = new int[node+1][node+1];

        for(int i=0;i<line;i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        BaekJoon1260 baekJoon1260 = new BaekJoon1260();
        baekJoon1260.DFS(graph, point, visited);
        Arrays.fill(visited,false);
        System.out.println();
        baekJoon1260.BFS(graph, point, visited);
    }

    private void DFS(int[][] graph, int point, boolean[] visited) {
        visited[point] = true;
        System.out.print(point + " ");
        for(int i=0;i<node+1;i++) {
            if (!visited[i] && graph[point][i] == 1)
                DFS(graph,i,visited);
        }
    }

    private void BFS(int[][] graph, int point, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(point);
        visited[point] = true;
        while(!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int i=1;i<graph[v].length;i++) {
                if (!visited[i] && graph[v][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
