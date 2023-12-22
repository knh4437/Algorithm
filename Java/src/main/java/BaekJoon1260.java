    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.lang.reflect.Array;
    import java.util.*;

    // 백준 1260번 - DFS와 BFS : https://www.acmicpc.net/problem/1260
    public class BaekJoon1260 {
        static ArrayList<Integer> A[];
        static boolean[] visited;

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            A = new ArrayList[N+1];
            for(int i=1;i<N+1;i++) {
                A[i] = new ArrayList<Integer>();
            }
            // 인접 리스트 초기화

            for (int i=0;i<M;i++) {
                st = new StringTokenizer(bf.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                A[s].add(e);
                A[e].add(s);
            }

            for(int i=1;i<N+1;i++) {
                Collections.sort(A[i]);
            }
            // 작은 것부터 정렬을 위한 컬렉션 정렬 함수

            visited = new boolean[N+1];
            DFS(V);
            System.out.println();
            visited = new boolean[N+1];
            BFS(V);
        }

        static void BFS(int v) {
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(v);
            visited[v] = true;

            while (!queue.isEmpty()) {
                int node = queue.poll();
                System.out.print(node + " ");
                for (int i : A[node]) {
                    if (!visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }

        static void DFS(int v) {
            if (visited[v])
                return;
            System.out.print(v + " ");
            visited[v] = true;
            for(int i : A[v]) {
                DFS(i);
            }
        }
    }
