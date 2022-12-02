import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int case_num = Integer.parseInt(bf.readLine());
        String s;
        for(int i=0;i<case_num;i++) {
            int sum = 0;
            int plus=1;
            s = bf.readLine();
            String[] chr = s.split("");
            for(int j=0;j<s.length();j++) {
                if (chr[j].equals("O")) {
                    sum+=plus;
                }
                else if (chr[j].equals("X")){
                    plus = 0;
                }
                plus++;
            }
            System.out.println(sum);
        }
    }
}
