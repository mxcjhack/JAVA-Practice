package org.example.dsa;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidPalindrome {

    public static int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(') stack.push(i);
            else {
                if(!stack.isEmpty()){
                    if(s.charAt(stack.peek()) == '(') stack.pop();
                    else stack.push(i);
                }
                else stack.push(i);
            }
        }

        int n = s.length();
        int res = 0;
        if(stack.isEmpty()) return n;
        while(!stack.isEmpty()){
            int x = stack.pop();
            res = Math.max(res, n - x - 1);
            n = x;
        }
        res = Math.max(res, n);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
    }
}
