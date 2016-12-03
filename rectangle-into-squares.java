//https://www.codewars.com/kata/rectangle-into-squares/train/java
import java.util.*;
public class SqInRect {
	
	public static List<Integer> sqInRect(int lng, int wdth) {
		if (lng == wdth) return null;
    List<Integer> a = new ArrayList<Integer>();
    while (lng * wdth > 0) {
      if (lng > wdth) {
        a.add(wdth);
        lng = lng - wdth;
      } else {
        a.add(lng);
        wdth = wdth - lng;
      }
    }
    return a;
	}
}
