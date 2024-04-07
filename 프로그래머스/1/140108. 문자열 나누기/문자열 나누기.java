class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 0;
        int diff = 0;
        char ch = s.charAt(0);
        
        for(int i=0;i<s.length();i++) {
            if (same == diff) {
                answer++;
                ch = s.charAt(i);
            }
            if (s.charAt(i) == ch) same++;
            else diff++;
        }
        
        return answer;
    }
}