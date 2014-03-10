package dataStructure.four;

/**
 * 链栈。
 */
public class LinkStack<T> {
	private class Node {
		T data;
		/** 指向前一个元素 */
		Node next;

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	Node top;
	int size = 0;

	public void push(T element) {
		top = new Node(element, top);
		size++;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T peek() {
		return top.data;
	}

	public T pop() {
		Node oldNode = top;
		top = top.next;
		// 释放指向前一个的引用
		oldNode.next = null;
		size--;
		return oldNode.data;
	}

	public static void main(String[] args) {
		LinkStack<String> stack = new LinkStack<String>();
		stack.push("aaaa");
		stack.push("bbbb");
		stack.push("cccc");
		stack.push("dddd");
		System.out.println("访问栈顶元素：" + stack.peek());
		System.out.println("第一次弹出栈顶元素：" + stack.pop());
		System.out.println("第二次弹出栈顶元素：" + stack.pop());
	}
}
