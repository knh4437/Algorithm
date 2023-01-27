// 거리 합 구하기 - https://softeer.ai/practice/info.do?idx=1&eid=635
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Level03_02 {
    static LinkedList<Integer[]>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        nodes = new LinkedList[N+1];
        long[] subTree = new long[N+1];
        long[] distSum = new long[N+1];
        int[] ans = new int[N+1];

        for(int i=0;i<N+1;i++) {
            nodes[i] = new LinkedList<>();
        }

        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            nodes[x].add(new Integer[]{y,t});
            nodes[y].add(new Integer[]{x,t});
        }

    }

}
