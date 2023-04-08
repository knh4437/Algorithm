import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 백준 11286 - 절대값 힙 : https://www.acmicpc.net/problem/11286
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> {
            int first_abs = Math.abs(o1);   // 절대값
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs)
                // o1이 더 크다면 양수 반환 -> o1과 o2의 자리 바꾸기
                // o2가 더 크다면 음수 반환 -> 자리 유지
                return (o1>o2)?1:-1;
            else
                return first_abs-second_abs;
                // 양수가 반환되면 o1의 절대값이 더 큰 경우 -> o2, o1순으로 정렬
                // 음수가 반환되면 o2의 절대갑싱 더 큰 경우 -> o1, o2순으로 정렬
        }));
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(bf.readLine());
            if (num == 0){
                if (queue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(queue.poll());
            }
            else {
                queue.add(num);
            }
        }
    }
}
