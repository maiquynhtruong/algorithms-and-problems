import java.util.*;
import java.lang.*;
import java.io.*;

class java.util.Arrays
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr = new int[]{1, 2, 5, 6, 7, 4, 6, 10, 15, 13, 24, 16, 22, 25, 11};
		/** Returns a fixed-size list backed by the specified array. **/
		List<Integer> list = Arrays.asList(arr);
		
		/** Searches a range of the specified array for the specified key using the binary search algorithm.
		Type can be primitive types or non-primitive using a Comparator object c to compare them
		Returns index of search key. Return value >= 0 iff key can be found
		**/
		int index = Arrays.binarySearch(char[] a, char key)
		int index2 = Arrays.binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c);
		
		/** Copies the specified array, truncating or padding with zeros, or false, or null
		 * (if necessary) so the copy has the specified length.
		 **/
		T[] newArr = Arrays.copyOf(T[] original, int newLength);

		/** Copies the specified range of the specified array into a new array.**/
		T[] newArr2 = Arrays.copyOfRange(T[] original, int from, int to);
		
		/** Assigns the specified long value to each element of the specified array of long.
		Type has to be primitive or reference
		*/
		Arrays.fill(long[] a, long val);
		/** Assigns the specified int value to each element of the specified range of the specified array of ints.**/
		Arrays.fill(float[] a, int fromIndex, int toIndex, float val);
		
		/** Sorts the specified array into ascending numerical order.**/
		Arrays.sort(float[] a);
		/** Sorts the specified range of the array into ascending order. **/
		Arrays.sort(char[] a, int fromIndex, int toIndex);
		
		/** Sorts the specified array of objects according to the order induced by the specified comparator.**/
		Arrays.sort(T[] a, Comparator<? super T> c);
		/**Sorts the specified range of the specified array of objects according to the order induced by the specified comparator.**/
		Arrays.	sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c)
		
		/** Returns a string representation of the contents of the specified array.**/
		Arrays.toString(boolean[] a);
    
    
	}
}

class String
{
	public static void main (String[] args) throws java.lang.Exception
	{
		/** Allocates a new String so that it represents the sequence of 
		characters currently contained in the character array argument.**/
		String s1 = new String(char[] value);
		/** Allocates a new String that contains characters from a subarray of the character array argument.**/
		String s2 = new String(char[] value, int offset, int count);
		/** Allocates a new string that contains the sequence of characters currently contained in the string buffer argument.**/
		String s3 = new String(StringBuffer buffer);
		/** Allocates a new string that contains the sequence of characters currently contained in the string builder argument.**/
		String s4 = new String(StringBuilder builder);
		
		/**Returns the char value at the specified index**/
		char c1 = s1.charAt(1);
		
		/** Compares two strings lexicographically. **/
		int result = s1.compareTo(s2);
		
		/** Returns true if and only if the string s1 contains the s2.**/
		boolean res1 = s1.contains(s2);
		
		/** Compares this string to the specified StringBuffer. **/
		
		/**Compares this string to the specified StringBuffer.**/
		StringBuffer sb1 = new StringBuffer();
		boolean res2 = s1.contentEquals(sb1);
		
		/**Tests if this string ends with the specified suffix.**/
		String suffix = "";
		boolean res3 = s1.endsWith(suffix);
		
		/** Compares this string to the other string. **/
		boolean res4 = s1.equals(s2);
		
		/** Returns a formatted string using the specified format string and arguments. **/
		String s5 = String.format(String format, Object... args);
		
		/** Copies characters from this string into the destination character array.**/
		char[] dst = new char[s1.length()];
		s1.getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin);
		
		/** Returns the index within this string of the first occurrence of the specified character.**/
		int index = s1.indexOf(int chr);
		/** Returns the index within this string of the first occurrence of the specified character, starting the search at the specified index.**/
		index = indexOf(int ch, int fromIndex);
		
		/** Returns the index within this string of the first occurrence of the specified substring. **/
		int index2 = s2.indexOf(str3);
		/** Returns the index within this string of the first occurrence of the specified substring, starting at the specified index. **/
		index2 = s2.indexOf(str3, 2);
		
		/** Returns true if, and only if, length() is 0. **/
		boolean res4 = s1.isEmpty();
		
		/** Returns the index within this string of the last occurrence of the specified character. **/
		int index3 = s2.lastIndexOf(int ch);
		/** Returns the index within this string of the last occurrence of the specified character, searching backward starting at the specified index. **/
		index3 = lastIndexOf(int ch, int fromIndex);
		
		/**Returns the index within this string of the last occurrence of the specified substring. **/
		int index4 = s3.lastIndexOf(String str);
		/** Returns the index within this string of the last occurrence of the specified substring, searching backward starting at the specified index. **/
		index4 = s4.lastIndexOf(String str, int fromIndex);
		
		int len = s4.length();
		
		/**Returns a new string resulting from replacing all occurrences of oldChar in this string with newChar. **/
		String newStr = s1.replace(char oldChar, char newChar);
		/**Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence. **/
		newStr = s1.replace("abcd", "cba");
		
		/**Replaces each substring of this string that matches the given regular expression with the given replacement. **/
		String newStr2 = s1.replaceAll(String regex, String replacement);
		/**Replaces the first substring of this string that matches the given regular expression with the given replacement. **/
		newStr2 = s1.replaceFirst(String regex, String replacement);
		
		/** Splits this string around matches of the given regular expression.**/
		String[] res = 	s3.split(String regex);
		/** Splits this string around matches of the given regular expression.**/
		res = s3.split(String regex, int limit);
		
		/**Tests if this string starts with the specified prefix. **/
		boolean res5 = 	s2.startsWith(String prefix);
		/**Tests if the substring of this string beginning at the specified index starts with the specified prefix.**/
		res5 = s2.startsWith(String prefix, int toffset);
		
		/** Returns a new string that is a substring of this string. **/
		String newStr3 = s2.substring(int beginIndex);
		newStr3 = s2.substring(int beginIndex, int endIndex);
		
		/** Converts this string to a new character array. **/
		char[] charArr = s2.toCharArray();
		
		/** Converts all of the characters in this String to lower case using the rules of the default locale.**/
		String newStr4 = s2.toLowerCase();
		/** Converts all of the characters in this String to upper case using the rules of the default locale. **/
		newStr4 = s2.toUpperCase();
		
		/** Returns a copy of the string, with leading and trailing whitespace omitted. **/
		String newStr5 = s2.trim();
		
		/** Returns the string representation of the long argument, or any other types **/
		String newStr6 = String.valueOf(long l);
		
	}
}
