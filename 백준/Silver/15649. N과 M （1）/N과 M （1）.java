import java.util.Scanner;

public class Main {
    private static int[] arr;
    private static boolean[] visited;
    private static int N;
    private static int M;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N];
        arr = new int[M];

        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for(int i:arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=N;i++) {
            if (visited[i-1])
                continue;
            visited[i-1] = true;
            arr[depth]=i;
            dfs(depth+1);
            visited[i-1] = false;
        }
    }
}
