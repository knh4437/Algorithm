// 성적 평균 - https://softeer.ai/practice/info.do?idx=1&eid=389&sw_prbl_sbms_sn=128367
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Level02_03 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> score = new ArrayList<Integer>();
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            score.add(Integer.valueOf(st.nextToken()));
        }
        for (int i=0;i<K;i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(getResult(a, b, score));
        }
    }

    private static String getResult(int a, int b, ArrayList<Integer> score) {
        double ans=0;
        for (int i=a;i<=b;i++) {
            ans += score.get(i-1);
        }
        double result = ans / (b-a+1);
        return String.format("%.2f", result);
    }
}
