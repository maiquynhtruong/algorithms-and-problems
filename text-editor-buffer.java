public class Buffer1() {
	Stack<Character> stack1;
	Stack<Character> stack2;
	// create an empty buffer
	public Buffer1() {
		stack1 = new Stack<Character>();
		stack2 = new Stack<Character>();
	}
	// insert c at the cursor position
	public void insert(char c) {
		stack1.push(c);
	}
	// character at the cursor position
	public char get() {
		return stack1.peek();
	}
	// delete and return the character at the cursor
	// left delete, more like backspace
	public char delete() {
		return stack1.pop();
	}
	// move the cursor k positions to the left
	public void left(int k) {
		// assuming no stackoverflow
		for (int i = 0; i < k; i++) {
			char temp = stack1.pop(); 
			stack2.push();
		}
	}
	// move the cursor k positions to the right
	public void right(int k) {
		for (int i = 0; i < k; i++) {
			char temp = stack2.pop(); 
			stack1.push();
		}
	}
	// number of characters in the buffer
	public int size() {
		return stack1.size() + stack2.size();
	}
}

public class Buffer2() {
	Stack<Character> leftStack;
	Stack<Character> rightStack;
	boolean reverse = true;
	public Buffer2() {
		leftStack = new Stack<Character>();
		rightStack = new Stack<Character>();
	}
	public void insert(char c) {
		leftStack.push(c);
	}
	public char get() {
		return leftStack.peek();
	}
	public char delete() {
		return rightStack.isEmpty() ? '\0' : rightStack.pop();
	}
	public void left(int k) {
		while (!leftStack.isEmpty() && --k >= 0) rightStack.push(leftStack.pop());
	}
	public void right(int k) {
		while (!rightStack.isEmpty() && --k >= 0) leftStack.push(rightStack.pop());
	}
	public int size() {
		return rightStack.size() + leftStack.size();
	}
	public String serializeBuffer(Stack<Character> buffer) {
		int size = buffer.size();
		StringBuilder sb = new StringBuilder();
		if (reverse) {
			for (int i = 0; i < size; i++) {
				sb.append(buffer.get(i));
			}
			reverse = !reverse;
		} else {
			for (int i = size - 1; i >= 0; i--) {
				sb.append(buffer.get(i));
			}
			reverse = !reverse;
		}
		return sb.toString();
	}
	// '*' means the position of the cursor
	public String toString() {
		serializeBuffer(leftStack) + '*' + serializeBuffer(rightStack);
	}
}
public class Editor() {
	Buffer1 buffer = new Buffer1();
	// Buffer2 buffer = new Buffer2();
	Scanner sc = new Scanner(System.in);
	
	System.out.println("This is a simple text editor.\n\n"
				+ "\t- '*' represents the location of the cursor.\n"
				+ "\t- Type any character and press enter to add it to the stream.\n"
				+ "\nThe following is a list of commands. "
				+ "\n\n\t+C\tAdd a special character (C) to the stream."
				+ "\n\t-\tRemove a character from the stream."
				+ "\n\t?\tGet information about the stream (i.e., the size)."
				+ "\n\t!\tQuit the text editor"
				+ "\n\t<#\tMove the cursor left by (#) number of places."
				+ "\n\t>#\tMove the cursor right by (#) number of places.\n\n");
	while (true) {
		System.out.println("\t" + buffer);
		System.out.print(">")
		String s = sc.nextLine();
		char c = s.isEmpty() ? '\0' : s.charAt(0);
		switch (c) {
			case '-':
				buffer.delete();
				break;
			case '?':
				System.out.println(buffer.size());
				break;
			case '!':
				System.out.println("So long");
				sc.close();
				break;
			case '<':
				int arg = new Integer(s.substring(1, s.length()));
				buffer.left(arg);
				break;
			case '>':
				int arg = new Integer(s.substring(1, s.length()));
				buffer.right(arg);
				break;
			case '\0':
				break;
			case '+':
				c = s.charAt(1);
			default:
				buffer.insert(c);
				break;
		}	
	}
	
}