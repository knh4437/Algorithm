import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = bf.readLine();
            if (input.equals("0"))
                break;
            String[] arr = input.split("");
            int last = arr.length-1;
            boolean flag=true;
            for(int i=0;i<arr.length/2;i++) {
                if (!arr[i].equals(arr[last])) {
                    flag = false;
                    break;
                }
                last--;
            }
            if (flag)
                sb.append("yes" + "\n");
            else
                sb.append("no" + "\n");
        }
        System.out.print(sb);
    }
}
