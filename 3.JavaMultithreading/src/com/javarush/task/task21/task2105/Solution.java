package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if(this == o)return true;
        if (!(o instanceof Solution))return false;
        Solution n = (Solution) o;
        return (this.first == n.first
                || (this.first != null &&this.first.equals(n.first)))
                && (this.last == n.last
                || (this.last != null && this.last.equals(n.last)));

    }

    @Override
    public int hashCode() {
        //int result = first.hashCode();
        //result = 31 * result + last.hashCode();
        //return result;
        int result = 1;
        result = 31 * result + ((first == null) ? 0 : first.hashCode());
        result = 31 * result + ((last == null) ? 0 : last.hashCode());
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
