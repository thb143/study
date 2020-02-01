package dataStructure.four;

/**
 * 栈。
 */
public class Stack {
	Object[] data;
	int top;
	int size;

	public Stack(int size) {
		this.size = size;
		data = new Object[size];
		this.top = -1;
	}

	/**
	 * 压入栈顶。
	 * 
	 * @param o
	 */
	public void push(Object o) {
		if (!isFull()) {
			data[++top] = o;
		}
	}

	/**
	 * 返回栈顶元素，并删除。
	 * 
	 * @return
	 * @throws Exception
	 */
	public Object pop() throws Exception {
		if (!isEmpty()) {
			return data[top--];
		}
		throw new Exception("栈空了");
	}

	public int getSize() {
		return top + 1;
	}

	public boolean isFull() {
		return top == size - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public static void main(String[] args) throws Exception {
		Stack stack = new Stack(100);
		stack.push(1);
		stack.push(2);
		System.out.println(stack.getSize() + "  " + stack.pop());
		System.out.println(stack.pop());
	}
}
