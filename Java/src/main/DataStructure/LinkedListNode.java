class LinkedList {
    Node header;

    static class Node {
        int data;
        Node next=null;
    }

    LinkedList() {
        header = new Node();
    }

    void append(int d) {
        Node end = new Node();
        end.data = d;       // 새로운 값을 갖는 노드 생성
        Node n = header;    // header을 시작점으로 시작
        while (n.next!=null) {
            n = n.next;
        }   // 노드의 끝에 도달할 때까지 반복
        n.next = end;
        // 노드의 마지막에 새로운 노드 추가
    }

    void delete(int d) {
        Node n = header;
        while (n.next!=null) {
            if (n.next.data==d)
                n.next = n.next.next;
            else
                n = n.next;
        }
    }

    void retrieve() {
        Node n = header.next;   // header는 시작을 알려주는 용도일 뿐, 실제 값은 next부터 담겨있음.
        while (n.next!=null) {
            System.out.printf(n.data+"->");
            n=n.next;
        }
        System.out.println(n.data);
    }
}
public class LinkedListNode {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.retrieve();
        ll.delete(1);
        ll.retrieve();
    }
}
