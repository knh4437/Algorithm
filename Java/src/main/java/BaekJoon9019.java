import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        while (T > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bfs(A,B);
            T--;
        }
    }

    private static void bfs(int A, int B) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited =  new boolean[10000];
        String[] answer = new String[10000];
        Arrays.fill(answer, "");
        visited[A] = true;
        queue.add(A);

        while (!queue.isEmpty() && !visited[B]) {
            int v = queue.poll();
            int d = (2*v)%10000;
            int s = (v==0)?9999:v-1;
            int l = (v%1000)*10 + v/1000;
            int r = (v%10) * 1000 + v/10;

            if (!visited[d]) {
                queue.add(d);
                visited[d] = true;
                answer[d] = answer[v] + "D";
            }

            if (!visited[s]) {
                queue.add(s);
                visited[s] = true;
                answer[s] = answer[v] + "S";
            }

            if (!visited[l]) {
                queue.add(l);
                visited[l] = true;
                answer[l] = answer[v] + "L";
            }

            if (!visited[r]) {
                queue.add(r);
                visited[r] = true;
                answer[r] = answer[v] + "R";
            }
        }
        System.out.println(answer[B]);
    }

}
