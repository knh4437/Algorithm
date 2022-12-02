import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String answer;
        StringTokenizer tk = new StringTokenizer(s);
        int A = Integer.parseInt(tk.nextToken());
        int B = Integer.parseInt(tk.nextToken());
        if (A<B)
            answer = "<";
        else if (A>B)
            answer = ">";
        else
            answer = "==";
        System.out.println(answer);
    }
}
