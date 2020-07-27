package linkedlist;

import java.util.Hashtable;

public class MyLinkedList1 {
	Node head = null; // 链表头结点

	/**
	 * 
	 * 向链表中添加一个元素
	 * 
	 * @param data:添加的元素
	 * 
	 */
	public void addNode(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;

	}

	/**
	 * 
	 * 删除第index个基点
	 * 
	 * @param index:待删除结点索引
	 * 
	 * @return 成功返回true，失败返回false
	 * 
	 */
	public boolean deleteNode(int index) {
		// 如果删除元素位置不合理
		if (index < 1 || index > length()) {
			return false;
		}

		// 删除第index个结点的元素
		if (index == 1) {
			head = head.next;
			return true;
		}

		int i = 2;
		Node preNode = head;
		Node curNode = head.next;
		while (curNode != null) {
			if (i == index) {
				preNode.next = curNode.next;
				return true;
			}
			preNode = curNode;
			curNode = curNode.next;
			i++;
		}
		return true;
	}

	/**
	 * 
	 * @return 返回链表的长度
	 * 
	 */
	public int length() {
		int length = 0;
		Node temp = head;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}

	/**
	 * 
	 * 对链表进行排序
	 * 
	 * @return 返回排序后链表的头结点
	 * 
	 */
	public Node orderList() {
		int temp = 0;
		Node curNode = head;
		Node nextNode = null;
		while (curNode.next != null) {
			nextNode = curNode.next;
			while (nextNode != null) {
				if (curNode.data > nextNode.data) {
					temp = curNode.data;
					curNode.data = nextNode.data;
					nextNode.data = temp;
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;
		}
		return head;

	}

	/**
	 * 
	 * 打印链表
	 * 
	 */
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
	}

	// 遍历链表，将遍历到的值存储到HashTable中，若当前遍历的值在HashTable中
	// 存在，则说明当前数据是重复的，因此删除。
	// 优点：时间复杂度低
	// 缺点：需要额外的存储空间
	public void deleteDuplecate(Node head) {
		Hashtable table = new Hashtable();
		Node tmp = head;
		Node pre = null;
		while (tmp != null) {
			if (table.containsKey(tmp.data)) {
				pre.next = tmp.next;
			} else {
				table.put(tmp.data, 1);
				pre = tmp;
			}
		}
	}

	// 对链表进行双重循环遍历，外循环正常遍历链表，假设外循环当前遍历的节点为
	// cur,内循环从cur开始遍历，若遇到与cur相同的值，则删除这个重复的节点。
	// 优点：不需要额外存储空间
	// 缺点：时间复杂度高
	public void deleteDuplecate1(Node head) {
		Node p = head;
		while (p != null) {
			Node q = p;
			while (q.next != null) {
				if (p.data == q.next.data) {
					q.next = q.next.next;
				} else {
					q = q.next;
				}
			}
			p = p.next;
		}
	}

	// 如何找出单链表中的倒数第K个元素
	// 方法1：
	// 先遍历一遍链表计算出链表长度n,要求出倒数第k个元素，转化为正数第n-k个元素，然后在遍历一遍链表，得到倒数第k个元素。
	// 缺点：要遍历2遍链表
	// 方法2：
	// 设置2个指针，让其中一个比另外一个先前移k-1步，然后两个指针同时往前移动。循环直到现行的指针值为null,另一个指针所在的位置就是所要查找的位置。
	public Node findElem(Node head, int k) {
		if (k < 1 || head == null) {
			return null;
		}
		Node p1 = head;
		Node p2 = head;
		for (int i = 0; i < k - 1; i++) { // 前移k-1步
			if (p2.next != null) {
				p2 = p2.next;
			} else {
				return null;
			}
			while (p2 != null) {
				p1 = p1.next;
				p2 = p2.next;
			}
			return p2;
		}
		return null;
	}

	// 4、如何实现链表的反转
	// 反转前：a->b->c->d
	// 反转后：a<-b<-c<-d
	public void ReverseIteratively(Node head) {
		Node pReversedHead = null;
		Node pNode = head;
		Node pPrev = null;
		while (pNode != null) {
			Node pNext = pNode.next;
			if (pNext == null)
				pReversedHead = pNode;
			pNode.next = pPrev;
			pPrev = pNode;
			pNode = pNext;
		}
		// return this.head = pReversedHead;
	}

	// 5、如何从尾到头输出单链表
	// 方法1：
	// 将链表反转，然后遍历输出
	// 缺点：需要额外的操作
	// 方法2：
	// 从头到尾遍历链表，将每个节点值放入栈中，遍历完链表后，从栈顶输出元素
	// 缺点：需要额外的栈空间
	// 方法3：
	// 递归的本质是栈结构
	// 要反转输出链表，每访问一个节点，先递归输出它后面的节点，再输出该节点自身，这样链表就反过来输出了。
	public void printListReversely(Node pListHead) {
		if (pListHead != null) {
			printListReversely(pListHead.next);
		}
		System.out.println(pListHead.data);
	}

	// 6、如何寻找单链表的中间结点
	// 方法1：
	// 遍历链表求出链表长度length，然后再遍历length/2的距离，即可查到中间结点。
	// 缺点：2次遍历链表
	// 方法2：
	// 若是双向链表，可以首尾同时并行，当2个指针相遇，就找到了中间元素。
	// 若是单链表，也采用双指针的方法，具体而言：(1)有两个指针同时从头开始遍历；
	// （2）一个快指针每次走2步，一个慢指针一次走1步；（3）快指针先到链表尾部，而慢指针刚好到达链表中部（当快指针到达尾部，若是奇数个元素，则慢指针指向的就是中间元素；若是偶数个元素，则慢指针指向的结点和慢指针的下一个结点都是中间结点。）
	public Node SearchMid(Node head) {
		Node p = this.head;
		Node q = this.head;
		while (p != null && q.next != null && p.next.next != null) {
			p = p.next.next;
			q = q.next;
		}
		return q;
	}

	// 7、如何检测一个链表中是否有环
	// 定义两个指针fast和slow，初始都指向链表头，fast每次前进两步，slow每次走一步，两个指针同时向前移动，快指针每次移动都要和慢指针进行比较，直到快指针等于慢指针，就证明这个链表是带环的单向链表，否则，证明是循环链表（fast先行到达尾部为null，则链表为无环链表）。
	public boolean IsLoop(Node head) {
		Node fast = head;
		Node slow = head;
		if (fast == null) {
			return false;
		}
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return !(fast == null || fast.next == null);
	}

	// 检测环的入口：
	public Node FindLoopPort(Node head) {
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}
		if (fast == null || fast.next == null)
			return null;
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	// 8、如何在不知道头指针的情况下删除指定结点
	// 分2种情况谈论：
	// 若待删除的结点为链表尾结点，则无法删除，因为删除后无法使其前驱结点的next指针置为空；
	// 若待删除的结点不为尾结点，则可以通过交换这个结点与其后继结点的值，然后删除后继结点
	public boolean deleteNode(Node n) {
		if (n == null || n.next == null)
			return false;
		int tmp = n.data;
		n.data = n.next.data;
		n.next = n.next.next;
		return true;
	}

	// 9、如何判断两个链表是否相交
	// 如果两个链表相交，那么他们一定有相同的尾结点。
	public boolean isIntersect(Node h1, Node h2) {
		if (h1 == null || h2 == null)
			return false;
		Node tail1 = h1;
		while (tail1.next != null) {
			tail1 = tail1.next;
		}
		Node tail2 = h2;
		while (tail2.next != null) {
			tail2 = tail2.next;
		}
		return tail1 == tail2;
	}

	// 时间复杂度：O(len1+len2)
	// 引申：如果两个链表相交，如何找到它们相交的第一个结点？
	// 首先，分别计算两个链表head1、head2的长度len1、len2（假设len1>len2），接着先对链表head1遍历（len1-len2）个结点到结点p，此时结点p和head2到它们相交的结点的距离相同，此时同时遍历两个链表，直到遇到相同的结点为止，这个结点就是相交的第一个结点。

	public static Node getFirstMeetNode(Node h1, Node h2) {
		if (h1 == null || h2 == null) {
			return null;
		}
		Node tail1 = h1;
		int len1 = 1;
		while (tail1.next != null) {
			tail1 = tail1.next;
			len1++;
		}
		Node tail2 = h2;
		int len2 = 1;
		while (tail2.next != null) {
			tail2 = tail2.next;
			len1++;
		}
		if (tail1 != tail2)
			return null;
		Node t1 = h1;
		Node t2 = h2;
		if (len1 > len2) {
			int d = len1 - len2;
			while (d != 0) {
				t1 = t1.next;
				d--;
			}
		} else {
			int d = len2 - len1;
			while (d != 0) {
				t2 = t2.next;
				d--;
			}
		}
		while (t1 != t2) {
			t1 = t1.next;
			t2 = t2.next;
		}
		return t1;
	}
	// 缺点：需要遍历2遍
	// O(len1+len2)

	public static void main(String[] args) {
		MyLinkedList1 list = new MyLinkedList1();
		list.addNode(2);
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(5);
		System.out.println("before order:");
		list.printList();
		list.orderList();
		System.out.println();
		System.out.println("after order:");
		list.printList();
		list.deleteNode(2);
		System.out.println();
		System.out.println("删除第二个节点后:");
		list.printList();
	}

}
