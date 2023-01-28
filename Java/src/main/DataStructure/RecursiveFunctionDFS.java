// 참조 : https://scshim.tistory.com/241
public class RecursiveFunctionDFS {

    public static void main(String[] args) {

        // 인덱스가 각각의 노드 번호가 될 수 있도록 0번 인덱스는 아무것도 없는 상태로 둔다.
        int[][] graph = {{},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}};
        boolean[] visited = new boolean[9];
        dfs(graph, 1, visited);
    }

    private static void dfs(int[][] graph, int index, boolean[] visited) {
        visited[index] = true;  // 방문 처리

        System.out.print(index + " ");
        // 방문한 노드에 인접한 노드 찾기
        for (int node : graph[index]) {
            // 인접한 노드가 방문한 적이 없다면 DFS 수행
            if (!visited[node])
                dfs(graph, node, visited);
        }
    }
}
