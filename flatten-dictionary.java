/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		HashMap<String, Object> dict = new HashMap<String, Object>();	
		dict.put("key1", "1");
		HashMap<String, Object> c = new HashMap<String, Object>();
		c.put("d", "3"); c.put("e", "1");
		HashMap<String, Object> key2 = HashMap<String, Object>();
		key2.put("a", "2"); key2.put("b", "3"); key2.put("c", c);
		dict.put("key2", key2);
		
		/**
		 * Input looks like this: 
		 * {
			 'Key1': '1',
  			 'Key2': {
    	  	 'a' : '2',
    		 'b' : '3',
    	     'c' : {
      		 'd' : '3',
      	     'e' : '1'
    	     		}
  			 	}
    	  	 }
    	  	 
    	  	 Output should look like this:
    	  	 {
				  'Key1': '1',
				  'Key2.a': '2',
				  'Key2.b' : '3',
				  'Key2.c.d' : '3',
				  'Key2.c.e' : '1'
			}
    	  	 
    	  **/
	}
	
	public void flattenDictionary(HashMap<String, Object>() dict, HashMap<String, String> h, String key, Object value) {
		if (value instanceof String) {
			h.put(key, (String) value);
		} else if (value instanceof HashMap<String, Object>) {
			for (String k : value.keySet()) {
				Object v = dict.get(k);
				flattenDictionary(h, key + "." + k, v);
			}
		}
	}
}
