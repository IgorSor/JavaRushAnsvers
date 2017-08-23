package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if(this == n)return true;
        if (!(n instanceof Solution))return false;
        Solution n1 = (Solution) n;
        return (this.first == n1.first
                || (this.first != null &&this.first.equals(n1.first)))
                && (this.last == n1.last
                || (this.last != null && this.last.equals(n1.last)));
    }

    public int hashCode() {
        int result = 1;
        result = 31 * result + ((first == null) ? 0 : first.hashCode());
        result = 31 * result + ((last == null) ? 0 : last.hashCode());
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
