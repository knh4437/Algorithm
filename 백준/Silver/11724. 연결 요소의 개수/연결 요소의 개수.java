import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 11724번 - 연결 요소의 개수 : https://www.acmicpc.net/problem/11724
public class Main {
    static ArrayList<Integer>[] A;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());   // node
        int m = Integer.parseInt(st.nextToken());   // edge
        A = new ArrayList[n+1];
        visited = new boolean[n+1];
        int count = 0;

        for (int i=1;i<n+1;i++)
            A[i] = new ArrayList<Integer>();    // 인접 리스트 초기화

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        for (int i=1;i<=n;i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    static void DFS(int v) {
        if (visited[v])
            return;
        visited[v] = true;
        for(int i : A[v]) {
            if (!visited[i])
                DFS(i);
        }
    }
}
