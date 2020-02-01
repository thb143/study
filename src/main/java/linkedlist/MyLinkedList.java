package linkedlist;

/**
 * 链表
 *
 */
public class MyLinkedList {
	Node head = null;
	
	/**
	 * 增加节点
	 * @param d
	 */
	public void addNode(int d) {
		Node newNode = new Node(d);
		if (head == null) {
			head = newNode;
			return;
		}
		
		Node tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		
		tmp.next = newNode;
	}
	
	public void printNode() {
		Node tmp = head;
		while(tmp != null) {
			System.out.print(tmp.data+",");
			tmp = tmp.next;
		}
	}
	
	/**
	 * 排序
	 */
	public void orderNode() {
		Node nextNode = null;
		Node curNode = head;
		int tmp = 0;
		
		while(curNode.hasNext()) {
			nextNode = curNode.next;
			while (nextNode.hasNext()) {
				if (nextNode.data < curNode.data) {
					tmp = nextNode.data;
					nextNode.data = curNode.data;
					curNode.data = tmp;
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;
		}
	}
	
	/**
	 * 反转
	 */
	public void rever() {
		Node reverHead = head;
		Node pNode = head;
		Node pPrev = null;
		
		while(pNode != null) {
			Node nextNode = pNode.next;
			if (!pNode.hasNext()) {
				reverHead = pNode;
			}
			
			pNode.next = pPrev;
			pPrev = pNode;
			pNode = nextNode;
		}
		head = reverHead;
	}
	
	/**
	 * 反转输出
	 * @param pHead
	 */
	public void printRever(Node pHead) {
		if (pHead != null) {
			printRever(pHead.next);
			System.out.print(pHead.data+",");
		}
	}

	public static void main(String[] args) {
		
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.addNode(8);
		myLinkedList.addNode(7);
		myLinkedList.addNode(4);
		myLinkedList.addNode(5);
		myLinkedList.addNode(3);
		myLinkedList.addNode(1);
		myLinkedList.addNode(9);
		myLinkedList.printNode();
		System.out.println();
		myLinkedList.orderNode();
		myLinkedList.printNode();
		
		System.out.println();
		myLinkedList.rever();
		myLinkedList.printNode();
		
		System.out.println();
		myLinkedList.printRever(myLinkedList.head);
	}
	
	class Node{
		Node next = null;
		int data;
		public Node(int data) {
			this.data = data;
		}
		
		boolean hasNext() {
			return next != null;
		}
	}
}
