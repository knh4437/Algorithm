import java.util.*;
class Solution {
    static ArrayList<String> list;
    public int solution(String s) {
        int answer = 0;
        list = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            list.add(s.substring(i, i+1));
        }
        int x = 0;
        while (x < s.length()) {
            if (solve(s))
                answer++;
            list.add(list.get(0));
            list.remove(0);
            x++;
        }

        
        return answer;
    }
    
    private static boolean solve(String s) {
        Stack<String> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            String tmp = list.get(i);
            try{
            switch (tmp) {
                case "[":
                case "{":
                case "(":
                    stack.push(tmp);
                    break;
                case "]":
                    if (!stack.pop().equals("[")) return false;
                    break;
                case "}": 
                    if (!stack.pop().equals("{")) return false;
                    break;
                case ")":
                    if (!stack.pop().equals("(")) return false;
                    break;
            }
            } catch (Exception e) {
                return false;
            }
            
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}