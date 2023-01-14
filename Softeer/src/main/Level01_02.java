// 근무 시간 - https://softeer.ai/practice/info.do?idx=1&eid=990&sw_prbl_sbms_sn=126402
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Level01_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] minutesTokens;
        int start =0, end =0;
        int result=0;
        for (int i=0;i<5;i++) {
            String[] tokens = bf.readLine().split(" ");
            for (int j=0;j< tokens.length;j++) {
                minutesTokens = tokens[j].split(":");
                if (j==0)
                    start = Integer.parseInt(minutesTokens[0]) * 60 + Integer.parseInt(minutesTokens[1]);
                else
                    end = Integer.parseInt(minutesTokens[0]) * 60 + Integer.parseInt(minutesTokens[1]);
            }
            result += end - start;
        }
        System.out.println(result);
    }
}
