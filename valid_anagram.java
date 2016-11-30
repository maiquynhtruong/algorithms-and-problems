//https://leetcode.com/articles/valid-anagram/
// http://ideone.com/ASqMcq
public class Main {
    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length()) return false;
        int len = s.length();
        //System.out.println(len);
        int cnt[] = new int[27];
        for (int i = 0; i < len; i++) 
            cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < len; i++)
        	cnt[t.charAt(i) - 'a']--;
        for (int i = 0; i < cnt.length; i++)
        	if (cnt[i] > 0) return false;
        return true;
            
    }
    public static void main(String args[]) {
    	Main m = new Main();
    	String s = "abc", t = "bar";
    	System.out.println(m.isAnagram(s, t));
    }
}
