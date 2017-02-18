/**
An example of reading input 
*/

public class Main{
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		int n = Integer.parseInt(br.readLine());
		//String[] strs = br.readLine().split(" ");
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int n = Integer.parseInt(st.nextToken());
		}	
		pw.println();
		pw.flush();
		pw.close();
	}
}
