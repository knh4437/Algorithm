import java.util.Scanner;
import java.util.Stack;

// 백준 1874번 - 스택 수열 : https://www.acmicpc.net/problem/1874
public class BaekJoon1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        Stack<Integer> stack = new Stack<>();
        boolean IsNo = false;
        for(int i=0;i<N;i++) {
            A[i] = sc.nextInt();
        }
        StringBuffer sb = new StringBuffer();
        int num=1;
        for(int i=0;i<A.length;i++) {
            if (A[i] >= num) {
                while (A[i] >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else {
                int top = stack.pop();
                if (top > A[i]) {
                    System.out.println("NO");
                    IsNo = true;
                    break;
                }
                else sb.append("-\n");
            }
        }
        if (IsNo==false)
            System.out.println(sb);
    }
}
