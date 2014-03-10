package dataStructure.four;

/**
 * 栈队列。
 */
public class LinkQueue<T> {
	private class Node {
		T data;
		/** 指向下一个节点 */
		Node next;

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	Node front;
	Node rear;
	int size;

	public LinkQueue(T element) {
		front = new Node(element, null);
		rear = front;
		size++;
	}

	public void push(T element) {
		Node newNode = new Node(element, null);
		// 将以前最后一个节点的下一个节点设置为新节点
		rear.next = newNode;
		// 将最后一个节点设置为新节点
		rear = newNode;
		size++;
	}

	public T pop() {
		Node oldNode = front;
		// 将第一个节点设置为以前第一个节点的下个节点
		front = front.next;
		// 将以前第一个节点的下一个指向节点置为空
		oldNode.next = null;
		size--;
		return oldNode.data;
	}

}
