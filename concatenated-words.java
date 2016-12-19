import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	String[] findAllConcatenatedWordsInADict(String[] words) {
		LinkedList<String> res = new LinkedList<String>();
		HashSet<String> concats = new HashSet<String>();
		HashSet<String> exists = new HashSet<String>();
		for (String s: words) {
			exists.add(s);
		}
		for (String s: exists) {
			if isConcatenated(s, concats, exists) {
				res.add(s);
			}
		}
		for (String s: res) {
			System.out.print(s + " ");
		}
	}
	
	boolean isConcatenated(String s, HashSet<String> concats, HashSet<String> exists) {
		if (concats.contains(s)) {
			return true;
		}
		
		String cur = "";
		
		for (int i = 0; i < s.length(); i++) {
			cur += s.charAt(i);
			if (exists.contains(cur)) {
				if (i == s.length() - 1) {
					return false;
				}
				String next = s.subString(i);
				if (exists.contains(next) || isConcatenated(next, concats, exists)) {
					concats.add(s);
					return true;
				}
			}
		}
		return false;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		
	}
}
