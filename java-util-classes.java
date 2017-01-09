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

class BigInteger
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BigInteger a = new BigInteger("12345");
		BigInteger b = new BigInteger("67891");
		
		BigInteger sum = a.add(b);
		BigInteger diff = a.subtract(b);
		BigInteger product = a.multiply(b);
		BigInteger quotient = a.divide(b);
		//Returns an array of two BigIntegers containing (this / val) followed by (this % val).
		BigInteger[] quotientAndRemainder = a.divideAndRemainder(b);
		BigInteger and = a.and(b); // a & b
		BigInteger andNot = a.andNot(b); // a & ~b
		int result = a.compareTo(b); //Compares this BigInteger with the specified BigInteger.
		double d = a.doubleValue(); // Converts this BigInteger to a double.
		float f = a.floatValue(); //Converts this BigInteger to a float.
		BigInteger gcd = a.gcd(b); //Returns a BigInteger whose value is the greatest common divisor of abs(this) and abs(val).
		int i = a.intValue(); //Converts this BigInteger to an int.
		long l = a.longValue(); //Converts this BigInteger to a long.
		int equal = a.equals(b); // a == b
		BigInteger max = a.max(b); //Returns the maximum of a and b
		BigInteger min = a.min(b); //Returns the minimum of a and b
		BigInteger mod = a.mod(b); // a mod b
		BigInteger modInverse = a.modInverse(b); // a^(-1) mod b
		BigInteger modPow = a.modPow(BigInteger exponent, BigInteger m); // a^(exponent) mod m
		BigInteger negate = a.negate(); // -a
		BigInteger not = a.not(); // ~a
		BigInteger or = a.or(b)); // a | b
		BigInteger pow = a.pow(int exponent); // a^(exponent)
		BigInteger remainder = a.remainder(b); // a % b
		BigInteger shiftRight = a.shiftRight(int n); // a >> n
		BigInteger shiftLeft = a.shiftLeft(int n); // a << n
		BigInteger xor = a.xor(b); // a xor b
		String num = a.toString(); // Returns the decimal String representation of this BigInteger.
		BigInteger bigLong = BigInteger.valueOf(long num); //Returns a BigInteger whose value is equal to that of the specified long.
	}
}
class Character
{
	public static void main (String[] args) throws java.lang.Exception
	{
		char a = 'a';
		boolean isLetter = Character.isLetter(a);
		boolean isLetterOrDigit = Character.isLetterOrDigit(a);
		boolean isLowerCase = Character.isLowerCase(a);
		boolean isUpperCase = Character.isUpperCase(a);
		boolean isSpaceChar = Character.isSpaceChar(a);
		boolean isWhiteSpace = Character.isWhiteSpace(a);
		char toLowerCase = Character.toLowerCase(a);
		char toUpperCase = Character.toUpperCase(a);
		Character c = Character.valueOf(a);
	}
}

class StringBuilder 
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String s = "abcdefgh";
		StringBuilder sb = new StringBuilder(s);
		// Appends string representation of E to the end of sb
		sb = sb.append(E e); // E can be any primitive type or toString() of an Object
		
		// Appends the string representation of the char array argument to this sequence.
		sb = sb.append(char[] str);
		// Appends the string representation of a subarray of the char array argument to this sequence.
		sb = sb.append(char[] str, int offset, int len)
		// Appends the specified string to this character sequence.
		sb = sb.append(String str)
		// Appends the specified StringBuffer to this sequence.
		append(StringBuffer sb)
		
		// Returns the char value in this sequence at the specified index
		char c = sb.charAt(int index)
		
		// Removes the characters in a substring of this sequence.
		sb = sb.delete(int start, int end)
		
		// Removes the char at the specified position in this sequence.
		sb.deleteCharAt(int index)
		
		// Characters are copied from this sequence into the destination character array dst.
		void sb.getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
		
		// Returns the index within this string of the first occurrence of the specified substring.
		int index = sb.indexOf(String str)
		// Returns the index within this string of the first occurrence of the specified substring, starting at the specified index.
		int index = sb.indexOf(String str, int fromIndex)
		
		// Inserts the string representation of the Object argument into this character sequence.
		// It can also be of primitive types
		sb = sb.insert(int offset, Object obj)
		// Inserts the string representation of a subarray of the str array argument into this sequence.
		sb = sb.insert(int index, char[] str, int offset, int len)
		// Inserts the string representation of the char array argument into this sequence.
		sb = sb.insert(int offset, char[] str)
		// Inserts the string into this character sequence
		sb = sb.insert(int offset, String str)
		
		// Returns the index within this string of the rightmost occurrence of the specified substring.
		index = sb.lastIndexOf(String str)
		// Returns the index within this string of the last occurrence of the specified substring.
		index = sb.lastIndexOf(String str, int fromIndex)
		
		// Replaces the characters in a substring of this sequence with characters in the specified String.
		sb = sb.replace(int start, int end, String str)
		
		// Causes this character sequence to be replaced by the reverse of the sequence.
		sb = sb.reverse()
		
		// The character at the specified index is set to ch.
		void setCharAt(int index, char ch)
		
		// Returns a new String that contains a subsequence of characters currently contained in this character sequence.
		String s = sb.substring(int start)
		// Returns a new String that contains a subsequence of characters currently contained in this sequence.
		s = sb.substring(int start, int end)
		
		// Returns a string representing the data in this sequence.
		s = sb.toString();
		
	}
}
