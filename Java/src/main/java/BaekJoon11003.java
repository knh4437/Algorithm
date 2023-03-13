import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 백준 11003 - 최솟값 찾기 : https://www.acmicpc.net/problem/11003
<<<<<<< HEAD:백준/Platinum/11003. 최솟값 찾기/최솟값 찾기.java
public class Main {
=======
public class BaekJoon11003 {
>>>>>>> 32f8ec1c4bce0621d45f77678e5195a44c8715c8:Java/src/main/java/BaekJoon11003.java

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Node> mydeque = new ArrayDeque<>();
        st = new StringTokenizer(bf.readLine());
        for (int i=0;i<N;i++) {
            int now = Integer.parseInt(st.nextToken());
            while (!mydeque.isEmpty() && (now < mydeque.getLast().value)) {
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(i, now));
            if (mydeque.getFirst().index <= i-L) {
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush();
        bf.close();
    }
}

class Node {
    public int index;
    public int value;
    
    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
