package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 *
 * 给定一颗二叉树，如果从根节点到某一叶节点的路径上数字之和等于指定的数字，返回真，否则返回假。
 * 
 * 例如：给定数字22，树的结构为
 * 
 * 5 / \ 4 8 / / \ 11 13 4 / \ \ 7 2 1 可以找到路径5->4->11->2，使5+4+11+2=22，因此返回真
 *
 * 
 */
public class TreeTest {

	List<List<Integer>> result = new ArrayList<>();

	public static void main(String[] args) {

		// 初始化二叉树 根节点
		BinaryTree tree = new TreeTest().new BinaryTree();
		tree.setData(5);

		// 左节点4 右节点8
		BinaryTree ltree1 = new TreeTest().new BinaryTree();
		ltree1.setData(4);
		BinaryTree rtree1 = new TreeTest().new BinaryTree();
		rtree1.setData(8);
		tree.setLeftChild(ltree1);
		tree.setRightChild(rtree1);

		// 4的左节点11
		BinaryTree ltree11 = new TreeTest().new BinaryTree();
		ltree11.setData(11);
		ltree1.setLeftChild(ltree11);

		// 8的左节点13 右节点4
		BinaryTree rtree1_l = new TreeTest().new BinaryTree();
		rtree1_l.setData(13);
		BinaryTree rtree1_r = new TreeTest().new BinaryTree();
		rtree1_r.setData(4);
		rtree1.setLeftChild(rtree1_l);
		rtree1.setRightChild(rtree1_r);

		// 11的左节点7 右节点2
		BinaryTree ltree11_l = new TreeTest().new BinaryTree();
		ltree11_l.setData(7);
		BinaryTree ltree11_r = new TreeTest().new BinaryTree();
		ltree11_r.setData(2);
		ltree11.setLeftChild(ltree11_l);
		ltree11.setRightChild(ltree11_r);

		// 4的左节点1
		BinaryTree rtree1_r_r = new TreeTest().new BinaryTree();
		rtree1_r_r.setData(1);
		rtree1_r.setRightChild(rtree1_r_r);

		List<Integer> list = new ArrayList<>();
		TreeTest treeTest = new TreeTest();
		treeTest.hasPathSum(tree, 22, list);

	}

	public void hasPathSum(BinaryTree root, int sum, List<Integer> list) {

		if (root == null) {
			return; // 如果节点未null，则返回
		}

		list.add(root.getData()); // 添加节点值到list里

		hasPathSum(root.getLeftChild(), sum - root.getData(), list); // 递归遍历左节点，每次遍历则减去当前节点值

		hasPathSum(root.getRightChild(), sum - root.getData(), list);// 递归遍历右节点，每次遍历则减去当前节点值

		if (root.getLeftChild() == null && root.getRightChild() == null) {
			// 如果叶节点的值等于22减去前面节点的值，则表示找到路径
			if (root.getData() == sum) {
				String ss = "";
				for (Integer i : list) {
					ss += i + "->";
				}
				System.out.println(ss); // 打印出路径
			}
		}
		// 递归完成后删除最后一个节点的值
		list.remove(list.size() - 1);
	}

	// 先序遍历
	public void preOrderTraverse(BinaryTree tree) {
		if (tree != null) {
			System.out.print(tree.getData() + "->");
			preOrderTraverse(tree.getLeftChild());
			preOrderTraverse(tree.getRightChild());
		}
	}

	/**
	 * 前序遍历（非递归方式） 1.先入栈根结点，输出根结点value值，再先后入栈其右结点、左结点；
	 * 2.出栈左结点，输出其value值，再入栈该左结点的右结点、左结点；直到遍历完该左结点所在子树。
	 * 3.再出栈右结点，输出其value值，再入栈该右结点的右结点、左结点；直到遍历完该右结点所在子树。
	 * 
	 * @param root
	 */
	public static void preOrder(BinaryTree root) {
		Stack<BinaryTree> stack = new Stack<>();
		if (root != null) {
			stack.push(root);
		}

		while (!stack.isEmpty()) {
			BinaryTree top = stack.pop();
			System.out.print(top.getData());
			if (top.getRightChild() != null) {
				stack.push(top.getRightChild());
			}
			if (top.getLeftChild() != null) {
				stack.push(top.getLeftChild());
			}
		}
	}

	/**
	 * 中序遍历（递归方式）
	 * 
	 * @param node
	 */
	public static void inOrderByRecursion(BinaryTree node) {
		if (node != null) {
			inOrderByRecursion(node.getLeftChild());
			System.out.print(node.getData());
			inOrderByRecursion(node.getRightChild());
		}
	}

	/**
	 * 中序遍历（非递归方式） 1.首先从根结点出发一路向左，入栈所有的左结点； 2.出栈一个结点，输出该结点value值，查询该结点是否存在右结点，
	 * 若存在则从该右结点出发一路向左入栈该右结点所在子树所有的左结点； 3.若不存在右结点，则出栈下一个结点，输出结点value值，同步骤2操作；
	 * 4.直到结点为null，且栈为空。
	 * 
	 * @param root
	 */
	public static void inOrder(BinaryTree root) {
		Stack<BinaryTree> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.getLeftChild();
			}
			if (!stack.isEmpty()) {
				BinaryTree top = stack.pop();
				System.out.print(top.getData());
				root = top.getRightChild();
			}
		}
	}

	/**
	 * 后序遍历（递归方式）
	 * 
	 * @param node
	 */
	public static void postOrderByRecursion(BinaryTree node) {
		if (node != null) {
			postOrderByRecursion(node.getLeftChild());
			postOrderByRecursion(node.getRightChild());
			System.out.print(node.getData());
		}
	}

	/**
	 * 后序遍历（非递归） 1.首先定义两个stack，将root结点压入stack1
	 * 2.stack1弹出栈顶元素，然后将该元素压入stack2，再将该元素的左结点与右结点压入stack1
	 * 3.循环步骤2，直到stack1为空，根据栈的LIFO的特性，这样遍历Stack2就会得到后序遍历的结果
	 * 
	 * @param root
	 */
	public static void postOrder(BinaryTree root) {
		if (root != null) {
			Stack<BinaryTree> stack1 = new Stack<>();
			Stack<BinaryTree> stack2 = new Stack<>();
			stack1.push(root);
			while (!stack1.isEmpty()) {
				BinaryTree top = stack1.pop();
				stack2.push(top);
				if (top.getLeftChild() != null) {
					stack1.push(top.getLeftChild());
				}
				if (top.getRightChild() != null) {
					stack1.push(top.getRightChild());
				}
			}
			while (!stack2.isEmpty()) {
				System.out.print(stack2.pop().getData());
			}
		}
	}

	/**
	 * 层次遍历
	 * 
	 * @param root
	 */
	public static void layerOrder(BinaryTree root) {
		Queue<BinaryTree> queue = new ArrayDeque<>();
		if (root != null) {
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
			BinaryTree node = queue.poll();
			System.out.print(node.getData());
			if (node.getLeftChild() != null) {
				queue.offer(node.getLeftChild());
			}
			if (node.getRightChild() != null) {
				queue.offer(node.getRightChild());
			}
		}
	}

	class BinaryTree {
		int data;
		BinaryTree leftChild;
		BinaryTree rightChild;

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public BinaryTree getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(BinaryTree leftChild) {
			this.leftChild = leftChild;
		}

		public BinaryTree getRightChild() {
			return rightChild;
		}

		public void setRightChild(BinaryTree rightChild) {
			this.rightChild = rightChild;
		}

	}

	public List<List<Integer>> getResult() {
		return result;
	}

	public void setResult(List<List<Integer>> result) {
		this.result = result;
	}

}
