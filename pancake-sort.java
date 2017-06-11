Pancake Sort

Given an array of integers arr:

Write a function flip(arr, k) that reverses the order of the first k elements in the array arr.
Write a function pancakeSort(arr) that sorts and returns the input array. You are allowed to use only the function flip you wrote in the first step in order to make changes in the array.
Example:

input:  arr = [1, 5, 4, 3, 2]

output: [1, 2, 3, 4, 5] # to clarify, this is pancakeSort's output
Analyze the time and space complexities of your solution.

Note: it’s called pancake sort because it resembles sorting pancakes on a plate with a spatula, where you can only use the spatula to flip some of the top pancakes in the plate. To read more about the problem, see the Pancake Sorting Wikipedia page.

Constraints:

[time limit] 5000ms

[input] array.integer arr

[input] integer k

0 ≤ k
[output] array.integer


import java.io.*;
import java.util.*;

class Solution {

  static int[] pancakeSort(int[] arr) {
      for (int i = arr.length - 1; i > 0; i--) {
          int index = indexOfBiggest(arr, i);
          
          flip(arr, index);
          flip(arr, i);
      }
      return arr;
  }
  
  static void flip(int[] arr, int k) {
      for (int i = 0; i < (k+1) / 2; i++) {
          int temp = arr[i];  
          arr[i] = arr[k - i];
          arr[k - i] = temp;
      }
  }
  
  static int indexOfBiggest(int[] arr, int end) {
      int index = 0, max = Integer.MIN_VALUE;
      for (int i = 0; i <= end; i++) {
          if (arr[i] > max) {
              max = arr[i];
              index = i;
          } 
      }
      return index;
  }

  public static void main(String[] args) {
      int[] arr = {1, 5, 4, 3, 2, 7, 6};
      int[] res = pancakeSort(arr);
      System.out.println(Arrays.toString(res));
  }

}
