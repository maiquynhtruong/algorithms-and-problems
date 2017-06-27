public class Solution {
    public ArrayList<String> permutation(String s) {
        if (s == null) return null;
        ArrayList<String> perm = new ArrayList<String>();
        if (s.length() == 0) {
            perm.add("");
            return perm;
        }
        char firstChar = s.charAt(0);
        s = s.substring(1);
        ArrayList<String> subPerm = permuatation(s);
        for (String word : subPerm) {
            for (int j = 0; j < word.length(); j++) {
                perm.add(createPermutation(word, j, firstChar));
            }
        }
    }
    
    public static String createPermutation(String word, int i, char c) {
            String pre = word.substring(0, i);
            String suf = word.substring(i+1);
            return pre + c + suf;
    }
    public static void main (String args[]) {
        
    }
}
