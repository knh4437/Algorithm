import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BaekJoon10845 {

    static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        while (N!=0) {
            String input = bf.readLine();
            StringTokenizer st = new StringTokenizer(input);
            boolean flag = true;
            int num=0;
            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    flag=false;
                    break;
                case "pop":
                    num = front();
                    if (num == -1)
                        break;
                    pop();
                    break;
                case "size":
                    num = size();
                    break;
                case "empty":
                    num = empty();
                    break;
                case "front":
                    num = front();
                    break;
                case "back":
                    num = back();
                    break;
            }
            if (flag) {
                System.out.println(num);
            }
            N--;
        }
    }

    private static void push(int index) {
        list.add(index);
    }

    private static void pop(){
        list.removeFirst();
    }

    private static int size() {
        return list.size();
    }

    private static int empty() {
        if (list.isEmpty())
            return 1;
        return 0;
    }

    private static int front() {
        if (list.isEmpty())
            return -1;
        return list.peek();
    }

    private static int back() {
        if (list.isEmpty())
            return -1;
        return list.peekLast();
    }
}

