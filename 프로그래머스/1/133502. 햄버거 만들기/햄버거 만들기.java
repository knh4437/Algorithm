import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        ArrayList<Integer> ingreList = new ArrayList<>();
        for(int i=0;i<ingredient.length;i++) {
            ingreList.add(ingredient[i]);
        }
        int i=0;
        while (i < ingreList.size()) {
            if (i+3 >=ingreList.size())
                break;
            
            if (i>=0 && ingreList.get(i)==1 && ingreList.get(i+1)==2 && ingreList.get(i+2) == 3 && ingreList.get(i+3) == 1) {
                for(int j=0;j<4;j++) {
                    ingreList.remove(i);
                }
                i-=4;
                answer++;
                continue;
            }
            i++;
        }
        return answer;
    }
}