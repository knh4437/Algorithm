import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int num = Integer.parseInt(s);
        int[] score = new int[num];
        double average = 0;
        s = bf.readLine();
        StringTokenizer token = new StringTokenizer(s);
        token = new StringTokenizer(s);
        for (int i=0;i<num;i++) {
            score[i] = Integer.parseInt(token.nextToken());
        }
        int big = 0;
        for(int i=0;i<score.length;i++) {
            if (score[i] >= big)
                big = score[i];
        }
        for(double a : score) {
            a = a/big*100;
            average += a;
        }
        System.out.println(average/score.length);




    }

}
