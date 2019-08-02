package com.ku.practice.med;

class Solution {

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            count += countSubstrings(s, i, i) + countSubstrings(s, i, i + 1);
        return count;
    }

    private int countSubstrings(String s, int start, int end) {
        int count = 0;
        // System.out.println( "loop starts " + start + " " + end );
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            // System.out.println(start + " " + end);
            count++;
            start--;
            end++;
        }

        return count;
    }

}