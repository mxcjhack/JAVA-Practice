package org.example.dsa;

/*
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
Code syntax: Java
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class KRepatingCharacterRemove {

    public static void main(String[] args) {
        String word = "deeedbbcccbdaf";
        int k = 3;

        Deque<Pair> stack = new ArrayDeque<>();
        int t = 0;

        for(char c : word.toCharArray()){
            if(stack.isEmpty()){
                stack.push(new Pair(c, 1));
            } else {
                if(stack.peek().character != c){
                        stack.push(new Pair(c, 1));
                } else {
                    if(stack.peek().count == 2){
                        stack.pop();
                    } else {
                        Pair p = stack.pop();
                        stack.push(new Pair(p.character, p.count + 1));
                    }
                }
            }
        }

        StringBuilder s = new StringBuilder();

        for(Pair pair : stack.reversed()){
            s.append(String.valueOf(pair.character).repeat(Math.max(0, pair.count)));
        }

        System.out.println(s.toString());
    }

}

class Pair{
    Character character;
    int count;

    public Pair(Character character, int count) {
        this.character = character;
        this.count = count;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
