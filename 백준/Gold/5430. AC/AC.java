import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Deque<String> deque;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        deque = new ArrayDeque<>();
        int T = Integer.parseInt(bf.readLine());
        while (T>0) {
            T--;
            boolean flag = true;
            boolean printFlag = true;
            String input = bf.readLine();   // RDD
            int N = Integer.parseInt(bf.readLine());    // 4
            String arr = bf.readLine();     // [1,2,3,4]
            st = new StringTokenizer(arr, ", | \\[ | \\ ]");
            while (st.hasMoreTokens())
                deque.add(st.nextToken());
            for(int i=0;i<input.length();i++) {
                String command = input.substring(i, i+1);
                switch (command) {
                    case "R":
                        if (flag) flag = false;
                        else flag = true;
                        break;
                    case "D":
                        if (!removeElement(flag)) {
                            sb.append("error" + "\n");
                            printFlag = false;
                            break;
                        }
                        break;
                }
                if (!printFlag)
                    break;
            }
            if (printFlag)
                printElement(flag);
        }
        System.out.print(sb);
    }

    private static boolean removeElement(boolean flag) {
        String res = null;
        if (flag)
            res=deque.poll();
        else
            res=deque.pollLast();

        if (res==null)
            return false;
        return true;
    }

    private static void printElement(boolean flag) {
        int comma = deque.size()-1;
        sb.append("[");

        if (flag)
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
                if (comma > 0) {
                    sb.append(",");
                    comma--;
                }
            }
        else
            while (!deque.isEmpty()) {
                sb.append(deque.pollLast());
                if (comma > 0) {
                    sb.append(",");
                    comma--;
                }
            }
        sb.append("]" + "\n");
    }
}
