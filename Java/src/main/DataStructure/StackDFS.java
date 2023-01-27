import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StackDFS {
    public static void main(String[] args) {
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
        StackDFS dfsExam = new StackDFS();
        dfsExam.dfs(graph, 1, visited);
    }

    private void dfs(int[][] graph, int index, boolean[] visited) {
        // 시작 노드 방문 처리
        visited[index] = true;
        System.out.print(index + " ");
        Deque<Integer> stack = new LinkedList<>();
        stack.push(index);

        while (!stack.isEmpty()) {
            int node = stack.peek();
            boolean hasNearNode = false;    // 방문하지 않은 인접 노드가 있는지 확인
            // 인접한 노드를 방문하지 않았을 경우, 스택에 넣고 방문 처리
            for (int i : graph[node]) {
                if (!visited[i]) {
                    hasNearNode = true;
                    stack.push(i);
                    visited[i] = true;  // 방문 처리
                    System.out.print(i + " ");
                    break;
                }
            }
            // 방문하지 않은 인접 노드가 없는 경우 해당 노드 꺼내기
            if (!hasNearNode)
                stack.pop();
        }
    }
}
