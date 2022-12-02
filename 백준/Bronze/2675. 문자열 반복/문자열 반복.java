import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        String k = "";
        for (int i=0;i<test;i++) {
            int R = sc.nextInt();
            String S = sc.next();
            String[] str = S.split("");
            for(int m =0;m<str.length;m++) {
                for(int j=0;j<R;j++) {
                    k += str[m];
                }
            }
            list.add(k);
            k = "";
        }
        for (int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }
}
