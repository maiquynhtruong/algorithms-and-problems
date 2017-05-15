import java.io.*;
import java.util.*;

class Solution {

  static int shiftedArrSearch(int[] shiftArr, int num) {
      int pivot = findPivot(shiftArr, 0, shiftArr.length-1);
      if (pivot == -1) return -1;
      if (shiftArr[pivot] > num) {
          return searchWithBinarySearch(shiftArr, pivot, shiftArr.length-1, num);
      } else {
          return searchWithBinarySearch(shiftArr, 0, pivot-1, num);
      }
  }
  
  static int searchWithBinarySearch(int[] arr, int start, int end, int num) {
      while (start <= end) {
          int mid = (start+end) / 2;
          if (arr[mid] == num) {
              return mid;
          } else if (arr[mid] > num) {
              end = mid-1;
          } else {
              start = mid+1;
          }
      }
      return -1;
  }
  
  static int findPivot(int[] shiftArr, int left, int right) {
    
    while (left <= right) {
        int mid = (left + right) / 2;
        if (shiftArr[mid] < shiftArr[mid-1]) {
            return mid;
        } else if (shiftArr[mid] > shiftArr[0]) {
            left = mid+1;
        } else {
            right = mid-1;
        }
    }
    
    return -1;
    
  }
  
  // If first value < mid 
  // * if search value is between first and mid then 
  // * search in first half
  // * Else search in second half
  // Else 
  // * if search value is between mid and last
  // * search second half
  // * else search first half.
  public static void main(String[] args) {
      int[] shiftArr = new int[]{10, 16, 17, 1, 2, 4, 5};
      int num = 17;
      int pivot = findPivot(shiftArr, 0, shiftArr.length-1);
      System.out.println(pivot);
      System.out.println(searchWithBinarySearch(shiftArr, 0, pivot, num));
      System.out.println(shiftedArrSearch(shiftArr, num));
  }

}
