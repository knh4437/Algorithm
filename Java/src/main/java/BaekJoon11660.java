import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11660번 - 구간 합 구하기 5 : https://www.acmicpc.net/problem/11660
public class BaekJoon11660 {
    private static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int length = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());
        int[][] D = new int[length+1][length+1];

        for (int i=1;i<length+1;i++) {
            st  = new StringTokenizer(bf.readLine());
            for (int j=1;j<length+1;j++) {
                D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<query;i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int ans = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
            System.out.println(ans);
        }
    }
}
