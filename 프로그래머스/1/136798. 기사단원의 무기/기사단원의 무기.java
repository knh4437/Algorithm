import java.math.*;
import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1;i<=number;i++) {
            answer+=getPower(power,limit,i);
        }

        
        return answer;
    }
    
    private static int getPower(int power, int limit, int x) {
        Set<Integer> set = new HashSet<>();
                
        for(int i=1;i<=Math.sqrt(x);i++) {
            if (x%i == 0) {
                set.add(i);
                set.add(x/i);
            }
        }
        
        if (set.size() > limit)
            return power;
        return set.size();
        
    }

}