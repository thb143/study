package tree;

import java.util.ArrayList;
import java.util.List;

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
				for (Integer i:list) {
					ss += i + "->";
				}
				System.out.println(ss); // 打印出路径
			}
		}
		// 递归完成后删除最后一个节点的值
		list.remove(list.size()-1);
	}

	// 先序遍历
	public void preOrderTraverse(BinaryTree tree) {
		if (tree != null) {
			System.out.print(tree.getData() + "->");
			preOrderTraverse(tree.getLeftChild());
			preOrderTraverse(tree.getRightChild());
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
