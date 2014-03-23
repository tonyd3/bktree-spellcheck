package com.td.bktree;


public class Utils {
    /**
     * Levenshtein Distance
     * Taken from an implementation during an interview :p
     *
     * @return The edit distance
     */
    public static int EditDistance(String s1, String s2) {
        if (s1.length() == 0) {
            return s2.length();
        }
        if (s2.length() == 0) {
            return s1.length();
        }
        int edit = (s1.charAt(0) == s2.charAt(0)) ? 0 : 1;

        int add = EditDistance(s1.substring(1), s2) + 1;
        int delete = EditDistance(s1, s2.substring(1)) + 1;
        int change = EditDistance(s1.substring(1), s2.substring(1)) + edit;
        return Math.min(change, Math.min(add, delete));
    }
}
