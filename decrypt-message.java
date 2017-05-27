public class Solution {
    public static String decryptMessage(String word) {
        // enc[n] = dec[n] + secondStep[n-1] - 26m (m is the number of times we need to add 26)
        // we want: dec[n] = enc[n] - secondStep[n-1] + 26m
        // since the value of the decrypted letter must be in the ASCII range of a-z, the decrypted letter 
        // is easily found adding 26’s to enc[n] - secondStep[n] until it is in the right range. 
        int secondPrev = 1;
        String retVal = "";
        for (int i = 0; i < word.size(); i++) {
            int temp = charToAscii(word.charAt(i)) - secondPrev;
            while (temp < 97) temp += 26;
            retVal += asciiToChar(temp);
            secondPrev += temp;
        }
        return retVal;
    }
    
    public char asciiToChar(int numeric) {
    }
}
/**
Decrypted message:	c	r	i	m	e
            Step 1:	99	114	105	109	101
            Step 2:	100	214	319	428	529
            Step 3:	100	110	111	116	113
Encrypted message:	d	n	o	t	q

*/
