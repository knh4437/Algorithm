import java.util.*;
import java.math.*;
class Node implements Comparable<Node>{
    int index;  // 도착 노드의 인덱스값
    int dist;   // 가중치
    
    Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}

class Solution {
    static List<List<Node>> graph = new ArrayList<>();
    static final int INF = 10_000_001;
    static int n;
    static boolean[] visited;
    static int[] distances;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        n = n;
        
        for(int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
        
        for(int i=0;i<paths.length;i++) {
            int a = paths[i][0];
            int b = paths[i][1];
            int dist = paths[i][2];
            graph.get(a-1).add(new Node(b-1, dist));
            graph.get(b-1).add(new Node(a-1, dist));
        }
        // 무뱡항 그래프
        
        for(int i=0;i<gates.length;i++) {
            for(int j=0;j<summits.length;j++) {
                visited = new boolean[n];
                distances = new int[n];
                Arrays.fill(visited, false);
                Arrays.fill(distances,INF);
                dijkstra(gates[i]-1, summits[j]-1);
            }
        }
        
        
        return answer;
    }
    
    private static void dijkstra(int gate, int summit) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        distances[gate] = 0;
        queue.add(new Node(gate, 0));
        int intensity = INF;
        int peak = INF;
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            visited[cur.index] = true;
            for(Node nextNode : graph.get(cur.index)) {
                int d = (nextNode.dist == INF) ? cur.dist : Math.max(cur.dist, nextNode.dist);
                if (distances[nextNode.index] > d) {
                    distances[nextNode.index] = d;
                    queue.add(new Node(nextNode.index, distances[nextNode.index]));
                    System.out.println(cur.index+1 + " -> " + (nextNode.index+1));
                }
            }
        }
        
    }
}