class Ideone
{
	int oneBits[] = new int[32];
	public static void main (String[] args) throws java.lang.Exception
	{
		int total = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < nums.length; j++) {
				if ((nums[j] >> i) & 1) oneBits[i] += 1;
			}
			total += oneBits[i] * (nums.length - oneBits[i]);
		}
		return total;
	}
}
