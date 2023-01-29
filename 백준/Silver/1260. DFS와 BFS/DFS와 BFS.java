import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

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

        Main main = new Main();
        main.DFS(graph, point, visited);
        Arrays.fill(visited,false);
        System.out.println();
        main.BFS(graph, point, visited);
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
