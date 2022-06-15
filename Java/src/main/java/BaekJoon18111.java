import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int min=256;
        int max=0;
        int time=0;
        int inven, answertime, answerheight;

        answertime = -1;
        answerheight = -1;
        int[][] field = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                if (min > field[i][j])
                    min = field[i][j];
                else if (max < field[i][j])
                    max = field[i][j];
            }
        }
        inven = b;
        for(int height=min;height<=max;height++) {
            // 최소값 ~ 최대값 사이 값을 높이로 설정하여 모두 계산
            time = 0;   // 각 높이 계산마다 시간 초기화
            inven = b;  // 각 높이 계산마다 인벤토리 초기화
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    if (height <= field[i][j]) {     // 현 블록이 높이보다 높을 경우 = 블럭 빼기
                        time += (field[i][j]-height)*2; // 높이 차이*2만큼 시간 더하기
                        inven += (field[i][j]-height);  // 높이 차이만큼 인벤에 넣기
                    }
                }
            }
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    if (height >= field[i][j]) {     // 현 블럭이 높이보다 낮을 경우 = 블럭 쌓기
                        time += (height-field[i][j]);   // 높이 차이만큼 시간 더하기
                        inven -= (height-field[i][j]);  // 높이 차이만큼 인벤에서 빼기
                    }
                }
            }
            if ((answertime == -1)&&(inven >= 0)) {
                answertime = time;
                answerheight = height;
            }
            if ((answertime >= time)&&(inven >= 0)&&(time>0)) {
                answertime = time;
                if (answerheight < height)
                    answerheight = height;
            }
        }
        System.out.println(answertime + " " + answerheight);
    }
}
