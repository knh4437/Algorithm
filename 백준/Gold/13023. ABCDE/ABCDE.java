import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 13023 - ABCDE : https://www.acmicpc.net/problem/13023
public class Main {
    static private ArrayList<Integer>[] A;
    static private boolean[] visited;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n];
        visited = new boolean[n];
        check = false;

        for(int i=0;i<n;i++)
            A[i] = new ArrayList<Integer>();

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        for(int i=0;i<n;i++) {
            Arrays.fill(visited, false);
            DFS(i, 1);
            if (check)
                break;
        }
        if (check)
            System.out.println("1");
        else
            System.out.println("0");
    }

    static void DFS(int num, int depth) {
        if (depth == 5 || check) {
            check = true;
            return;
        }

        visited[num] = true;
        for(int i: A[num]){
            if (!visited[i]){
                visited[i] = true;
                DFS(i,depth+1);
                visited[i] = false;
            }
        }
    }
}
