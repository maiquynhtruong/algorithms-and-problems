// http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/


public class Main {
	static class Node {
		int value;
		Node next;
		public Node(int val) {
			this.value = val;
			this.next = null;
		}
	}
	static Node head;

	boolean detectAndRemoveLoops(Node head) {

		Node slow = head;
		Node fast = head;
		while (slow != null && fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				
				System.out.println("slow: " + slow.value + ", fast:" + fast.value);
				removeLoops(head, slow);
				return true;
			}
		}
		return false;
	}

	
	// The proof with very beautiful explanation can be found here: http://javabypatel.blogspot.in/2015/12/detect-loop-in-linked-list.html
	
	void removeLoops(Node head, Node cur) {
		
		// we know the distance from the beginning of the list to start of loop is the same as distance
		// from meeting point to start of loop, so we can have one pointer at the beginning, keep the other
		// at the meeting point and move them in step of 1

		// That's to find out where is the start of the loop. To remove it, we need to keep pointer 2 running in the loop 
		// for every node pointer 1 moves to. When pointer 2's next reaches pointer 1, we know pointer 2 is now the previous node
		// before the start of loop node, and we can set pointer 2 to null
		
		Node p1 = head, p2 = null;
		while (true) {
			p2 = cur; // point two pointers just met
			while (p2.next != cur && p2.next != p1)
				p2 = p2.next;
			if (p2.next == p1) 
				break; // we found the start of loop, break out
			// otherwise we keep pointer 1 moving and start a new loop for pointer 2
			p1 = p1.next;
		}
		// since pointer 2 is the pointer before the start of loop, we can set it to null
		System.out.println("pointer1: " + p1.value + ", pointer2: " + p2.value);
		p2.next = null;
	}

	public void printList(Node head) {
		Node cur = head;
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}	
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		head = new Node(50);
		head.next = new Node(20);
		head.next.next = new Node(15);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(10);
		// Create a loop right here right now
		head.next.next.next.next.next = head.next.next;
		// Visually it looks like this:
		// 50 -> 20 -> 15 -> 4
		//              |    |
		//               <- 10
		m.detectAndRemoveLoops(head);
		m.printList(head);
	}
}