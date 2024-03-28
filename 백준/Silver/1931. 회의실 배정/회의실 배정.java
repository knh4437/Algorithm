import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = 1;
        int N = Integer.parseInt(bf.readLine());
        int[][] times = new int[N][2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        // 끝나는 시간 기준 오름차순 정렬
        // 같을 경우, 시작 시간이 느린 순(소요 시간이 짧은)으로 정렬

        int now = times[0][1];

        for(int i=1;i<N;i++) {
            if (times[i][0] >= now) {
                now = times[i][1];
                count++;
            }
        }

        System.out.println(count);

    }
}
