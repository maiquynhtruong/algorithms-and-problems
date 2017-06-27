/** Print all valid combinations of n pairs of parentheses */
public class Solution {
    public static ArrayList<String> printParen(ArrayList<String> parens, int left, int right, char[] str, int index) {
        if (left < 0 || right > left) return;
        if (left == 0 && right == 0) {
            parens.add(String.copyValueOf(str));
            return;
        }
        if (left > 0) {
            str[index] = '(';
            printParen(parens, left-1, right, str, index+1);
        } 
        if (right > 0) {
            str[index] = ')';
            printParen(parens, left, right-1, str, index+1);
        }
    }
    public static void main(String args[]) {
    
    }
}
