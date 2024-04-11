import java.util.*;
import java.math.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int maxScore = 0;
        int[] WON = scores[0];
        
        
        // 동료 평가 오름차순
        // 같다면, 근무 태도 내림차순
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0])
                    return o1[1] - o2[1];
                return o2[0]-o1[0];
            }
        });
        
        for(int[] score : scores) {
            if (score[1] < maxScore) {
                if (score[0] == WON[0] && score[1] == WON[1])
                    return -1;
            } else {
                maxScore = Math.max(maxScore, score[1]);
                if (score[0] + score[1] > WON[1]+WON[0])
                    answer++;
            }
        }
        return answer+1;
    }
}