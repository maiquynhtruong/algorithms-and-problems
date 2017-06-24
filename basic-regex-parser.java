public class Solution {
    public static basicParser(String text, String pattern) {
        int dp[][] = new int[text.length()][pattern.length()];
        for (int i = 0; i < text.length(); i++)
            for (int j = 0; j < pattern.length(); j++) {
                if (i == 0) dp[i][j] = 0;
                else if (j == 0) dp[j] = 0;
                else if (pattern.charAt(j) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (pattern.charAt(j) == '*') {
                    if (pattern.charAt(j-1) == '.') {
                        cur = text.charAt(i-1);
                    } else {
                        cur = pattern.charAt(j-1);
                    }
                    if (text.charAt(i) == cur) dp[i][j] = true;
                } else if (text.charAt(i) == pattern.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                } else if (text.charAt(i) != pattern.charAt(j)) {
                    dp[i][j] = false;
                }
            }
    }
    
    public static parserRecursive(String text, String pattern, int textIndex, int patIndex) {
        if (textIndex >= text.length() ) {
            if (patIndex >= pattern.length()) {
                return true;
            } else {
                if (patIndex+1 < pattern.length() && pattern.charAt(patIndex+1) == '*') {
                    return parserRecursive(text, pattern, textIndex, patIndex+2); 
                } else {
                    return false;
                }
            }
        } else if (textIndex < text.length() && patIndex >= pattern.length()) {
            return false;
        } eles if (patIndex+1 < pattern.length() && pattern.charAt(patIndex+1) == '*') {
            if (pattern.charAt(patIndex) == '.' || pattern.charAt(patIndex) == text.charAt(textIndex)) {
                return parserRecursive(text, pattern, textIndex, patIndex+2) || parserRecursive(text, pattern, textIndex+1, patIndex);
            } else {
                return parserRecursive(text, pattern, textIndex, patIndex+2);
            }
        } else if (pattern.charAt(patIndex) == '.' || pattern.charAt(patIndex) == text.chartAt(textIndex)) {
            return parserRecursive(text, pattern, text+1, patIndex+1);
        }
    }

}
