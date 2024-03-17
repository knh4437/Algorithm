import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1389 {
    private static final int INF = 1_000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dist = new int[N+1][N+1];
        int[] result = new int[N];
        int index=-1;
        int val = Integer.MAX_VALUE;

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            int h = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            dist[h][r] = 1;
            dist[r][h] = 1;
        }

        for(int i=1;i<=N;i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j]!=1 && i!=j)
                    dist[i][j] = INF;
            }
        }

        for(int k=1;k<=N;k++) {
            for(int start=1;start<=N;start++){
                for(int end=1;end<=N;end++) {
                    dist[start][end] = Math.min(dist[start][end], dist[start][k] + dist[k][end]);
                }
            }
        }

        for(int i=1;i<=N;i++) {
            for (int j = 1; j <= N; j++) {
                result[i-1] += dist[i][j];
            }
        }

        for (int i=0;i<N;i++) {
            if (val > result[i]) {
                index = i+1;
                val = result[i];
            }
        }
        System.out.println(index);
    }
}
