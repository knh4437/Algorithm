
import java.util.*;

// 백준 1167번 - 트리의 지름 : https://www.acmicpc.net/problem/1167
class Edge {
    int node;
    int value;

    Edge(int node, int value) {
        this.node=node;
        this.value=value;
    }
}

public class BaekJoon1167 {
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Edge>[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        distance = new int[N+1];
        visited = new boolean[N+1];
        A = new ArrayList[N+1];
        for (int i=1;i<=N;i++)
            A[i] = new ArrayList<Edge>();

        for(int i=0;i<N;i++) {
            int s = sc.nextInt();
            while (true) {
                int e = sc.nextInt();
                if (e == -1)
                    break;
                int v = sc.nextInt();
                A[s].add(new Edge(e,v));
            }
        }
        BFS(1);
        int max=1;
        for (int i=2;i<=N;i++) {
            if (distance[max] < distance[i])
                max = i;
        }
        visited = new boolean[N+1];
        distance = new int[N+1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    private static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(num);
        visited[num] = true;

        while (!queue.isEmpty()) {
            int e = queue.poll();
            for (Edge i : A[e]) {
                int node = i.node;
                int value = i.value;
                if (visited[node])
                    continue;
                visited[node] = true;
                queue.add(node);
                distance[node] = distance[e] + value;
            }
        }
    }
}
