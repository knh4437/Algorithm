import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1107 {
    private static boolean[] broken;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        broken = new boolean[10];
        if (M!=0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        int result = Math.abs(N - 100);

        for(int i=0;i<=999999;i++) {
            String num = String.valueOf(i);
            boolean flag = false;

            for(int len=0;len<num.length();len++) {
                // 고장난 버튼을 사용할 경우
                if (broken[num.charAt(len) - '0']) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                int min = Math.abs(N - i) + num.length();
                // Math.abs() : +, -를 이용하여 버튼 동작한 횟수
                // num.length() : 숫자 버튼을 이용하여 직접 이동한 횟수
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }

}
