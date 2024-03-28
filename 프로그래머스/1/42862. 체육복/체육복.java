import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // 선택 절차 : 각 배열을 오름차순으로 정렬한다
        
        for(int i=0;i<lost.length;i++) {
            for(int j=0;j<reserve.length;j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    reserve[j] = -1;
                    lost[i] = -1;
                    break;
                }   
            }
        }
        // 도난당한 학생 중 여벌이 있는 학생 수 계산
        
        for(int i=0;i<lost.length;i++) {
            for(int j=0;j<reserve.length;j++) {
                if (lost[i] == reserve[j]-1 || lost[i] == reserve[j]+1) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        // 도난당한 학생 중 여벌이 없는 학생 수 계산
        return answer;
    }
}