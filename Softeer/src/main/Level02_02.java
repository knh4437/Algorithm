// GBC - https://softeer.ai/practice/info.do?idx=1&eid=584
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level02_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int result = 0;
        int limitLength = Integer.parseInt(st.nextToken());
        int realityLength = Integer.parseInt(st.nextToken());
        int[][] limit = requestValue(limitLength, new int[limitLength][2], bf);
        int[][] reality = requestValue(realityLength, new int[realityLength][2], bf);
        int n=0, a;

        for (int i=0;i<limitLength;i++) {
            for (int j=n;j<realityLength;j++) {
                if (limit[i][0] < reality[j][0]) {
                    reality[j][0] -= limit[i][0];
                    if ((a = reality[j][1] - limit[i][1]) > 0) result = Math.max(result, a);
                    break;
                } else if (limit[i][0] > reality[j][0]) {
                    limit[i][0] -= reality[j][0];
                    if ((a = reality[j][1] - limit[i][1]) > 0) result = Math.max(result, a);
                    n++;
                } else {
                    if ((a = reality[j][1] - limit[i][1]) > 0) result = Math.max(result, a);
                    n++;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    private static int[][] requestValue(int length, int[][] list, BufferedReader bf) throws IOException {
        int sum=0;
        for (int i=0;i<length;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
            sum+=list[i][0];
        }
        return list;
    }
}
