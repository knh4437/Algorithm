import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 17298번 - 오큰수 : https://www.acmicpc.net/problem/17298
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int A[] = new int[N];
        int result[] = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<N;i++) {
            int num = A[i];
            while (!stack.isEmpty() && A[stack.peek()] < num) {
                int top = stack.pop();
                result[top] = num;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int top = stack.pop();
            result[top] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0;i<N;i++) {
            bw.write(result[i] + " ");
        }
        bw.close();
    }
}
