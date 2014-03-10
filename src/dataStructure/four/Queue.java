package dataStructure.four;

public class Queue {
	Object[] data;
	int size;
	int front;
	int rear;

	public Queue(int size) {
		data = new Object[size];
		this.size = size;
		this.front = 0;
		this.rear = 0;
	}

	public void push(Object o) {
		if (!isFull()) {
			data[rear] = o;
			rear++;
		}
	}

	public Object pop() throws Exception {
		if (!isEmpty()) {
			return data[front++];
		} else {
			throw new Exception("空");
		}
	}

	public boolean isFull() {
		return rear == size - 1;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public static void main(String[] args) throws Exception {
		Queue queue = new Queue(10);
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println(queue.front);
		System.out.println(queue.rear);
		System.out.println(queue.pop());
		System.out.println(queue.front);
		System.out.println(queue.rear);
	}
}
