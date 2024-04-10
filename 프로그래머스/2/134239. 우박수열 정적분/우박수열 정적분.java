import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        double prev = k;
        int n = 1;
        ArrayList<Double> prefix = new ArrayList<>();
        prefix.add(0.0);
        while (k>1) {
            if (k%2==0) k/=2;
            else k = 3*k + 1;
            double num = prefix.get(n-1) + (k+prev)/2;
            prefix.add(num);
            prev = k;
            n++;
        }
        
        for(int i=0;i<ranges.length;i++) {
            int x = ranges[i][0];
            int y = n-1 + ranges[i][1];
            
            if (x==y) {
                answer[i] = 0.0;
                continue;
            }
            else if (x>y) {
                answer[i] = -1.0;
                continue;
            }
            answer[i] = prefix.get(y)-prefix.get(x);
        }
        
        
        return answer;
    }
}