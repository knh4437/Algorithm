import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] mx = {0, 1, 0, -1};
    private static int[] my = {1, -1, 1, 1};
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2, N);
        solve(size, r, c, 0, 0);
        System.out.println(count);
    }

    private static void solve(int n, int r, int c, int x, int y) {
        n /= 2;
        // 왼쪽 상단
        if (r < x + n && c < y + n) {
            count += (n*n*0);
        }
        // 오른쪽 상단
        else if (r < x+n) {
            count += (n*n*1);
            y+=n;
        }
        // 왼쪽 하단
        else if ( c < y+n) {
            count += (n*n*2);
            x+=n;
        }
        // 오른쪽 하단
        else {
            count += (n*n*3);
            x+=n;
            y+=n;
        }

        if (n==1)
            return;
        solve(n,r,c,x,y);
    }
}
