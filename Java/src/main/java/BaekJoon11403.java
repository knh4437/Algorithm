import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11403 {

    private static int[][] arr;
    private static int[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        answer = new int[N][N];
        for (int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j=0;j<N;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<N;i++) {
            dfs(N, i, i);
        }

        for (int i=0;i<N;i++) {
            for (int j = 0; j < N; j++)
                System.out.print(answer[i][j] + " ");
            System.out.println();
        }
    }

    private static void dfs(int N, int prev, int next) {
        for (int i=0;i<N;i++) {
            if (arr[next][i]==1 && answer[prev][i]==0) {
                answer[prev][i] = 1;
                dfs(N, prev, i);
            }
        }
    }
}
