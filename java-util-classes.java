import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
/*****************************************java.util.Arrays*****************************************************************************/
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
