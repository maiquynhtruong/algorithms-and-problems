// http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
class Ideone {
	class Node {
		int value;
		Node next;
		public Node(int val) {}
			this.value = val;
			this.next = null;
		}
	}
	Node head;

	boolean detectLoops(Node head) {

		Node slow = head;
		Node fast = head;
		while (slow != null && fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		head = new Node(50);
		head.next = new Node(20);
		head.next.next = new Node(15);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(10);
		// Create a loop right here right now
		head.next.next.next.next = head.next.next;
		// Visually it looks like so:
		// 50 -> 20 -> 15 -> 4
		//              |    |
		//               <- 10

	}
}