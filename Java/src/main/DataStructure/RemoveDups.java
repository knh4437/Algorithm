class LinkedList_removedups {
    Node header;

    static class Node {
        int data;
        Node next=null;
    }

    LinkedList_removedups() {
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

    void removeDups() {
        Node n = header;
        while (n != null && n.next!=null) {
            // n!=null : 마지막 노드 값이 중복이여서 삭제할 경우, 다음에 붙을 노드가 없기 때문에 문제가 발생할 수 있어 필요한 조건식
            Node r = n;
            while (r.next!=null) {
                if (n.data == r.next.data) {
                    r.next = r.next.next;
                }
                else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }
}
public class RemoveDups {
    public static void main(String[] args) {
        LinkedList_removedups ll = new LinkedList_removedups();
        ll.append(3);
        ll.append(3);
        ll.retrieve();
        ll.removeDups();
        ll.retrieve();
    }
}
