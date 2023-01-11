import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 프로그래머스-두 큐 합 같게 만들기 https://school.programmers.co.kr/learn/courses/30/lessons/118667
public class makeQueueValueEqual {
    public static void main(String[] args) {
        init();
    }

    private static void init() {
        int queue1[] = {3,2,7,2};
        int queue1_len = 4;
        int queue2[] = {4,6,5,1};
        int queue2_len = 4;
        solution(queue1,queue1_len,queue2,queue2_len);
    }
    private static int solution(int[] queue1, int queue1_len, int[] queue2, int queue2_len) {
        int answer = -2;
        List<Integer> queue1List = setQueueList(queue1);
        List<Integer> queue2List = setQueueList(queue2);
        // 동적 할당으로 변경
        

        return answer;
    }

    private static List<Integer> setQueueList(int[] queue) {
        List<Integer> queueList = new ArrayList<>();
        for(int i=0;i<queue.length;i++) {
            queueList.add(queue[i]);
        }
        return queueList;
    }
}
