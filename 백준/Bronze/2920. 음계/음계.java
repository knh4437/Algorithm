import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int[] num = new int[8];
        String answer="";
        int one = 1;
        int eight = 8;
        for (int i=0;i<num.length;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        if (num[0]==one) {
            for(int i=0;i<num.length;i++) {
                if (num[i] != one) {
                    answer = "mixed";
                    break;
                } else {
                    answer = "ascending";
                    one++;
                }
            }
        }
        else if (num[0] == eight) {
            for (int i = 0; i < num.length; i++) {
                if (num[i] != eight) {
                    answer = "mixed";
                    break;
                } else {
                    answer = "descending";
                    eight--;
                }
            }
        }
        else
            answer = "mixed";

        System.out.println(answer);
    }
}
