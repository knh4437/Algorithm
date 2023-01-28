// 참조 : https://scshim.tistory.com/241
import java.util.LinkedList;
import java.util.Queue;

public class QueueBFS {
    public static void main(String[] args) {
        int [][]graph = {{},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}};
        boolean[] visited = new boolean[9];
        QueueBFS queueBFS = new QueueBFS();
        queueBFS.BFS(graph, 1, visited);
    }

    private void BFS(int[][] graph, int index, boolean[] visited) {
        // 큐 선언
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;  // 방문처리
        while (!queue.isEmpty()) {
            // 큐 맨 앞 값 반환 후 삭제
            int v = queue.poll();
            System.out.print(v + " ");

            for (int i : graph[v]) {
                // 인접한 노드 중 아직 방문하지 않은 원소들을 큐에 삽입, 방문처리
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
