class Ideone
{
	public boolean canMakeSquare(int[] nums) 
	{
		if (nums == null || nums.length == 0)
		{
			return false;
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++)
		{
			sum += nums[i];
		}
		if (sum % 4 != 0)
		{
			return false;
		}
		return canFormSquare(nums, visited, sum/4, 0, 0, 0);
	}
	
	public boolean canFormSquare(int[] nums, boolean[] visited, int sum, int edgeLen, int start, count) 
	{
		if (count == 3)
		{
			return true;
		}
		if (edgeLen == sum)
		{
			if (canFormSquare(nums, visited, sum, 0, 0, count+1))
			{
				return true;
			}
		}
		for (int i = 0; i < nums.length; i++)
		{
			if (!visited[i] && edgeLen + nums[i] <= sum) 
			{
				visited[i] = true;
				if (canFormSquare(nums, visited, sum, edgeLen + nums[i], i+1, count))
				{
					return true;
				}
				visited[i] = false;
			}
		}
		return false;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	}
}
