public class Solution {
    public static boolean oneDistanceAway(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) return false;
        if (s1.length() > s2.length()) {
            String temp = s2; s2 = s1; s1 = temp;
        }
        int index1, index2;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) return false;
                foundDifference = true;
                if (s1.length() == s2.length()) index1++;
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }
    public static void main(String args[]) [
        
    }
}   
