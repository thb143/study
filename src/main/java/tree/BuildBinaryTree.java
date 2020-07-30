package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * ���⣺ ����ĳ��������ǰ���������������Ľ�������ؽ����ö������� ���������ǰ������������������ж������ظ������֡� ��������:
 * ǰ���������{"A","B","D","H","I","E","J","C","F","K","G"}��
 * �����������{"H","D","I","B","E","J","A","F","K","C","G"}�� ���ؽ�����������������ĸ���㡣
 * 
 * ������ �ڶ�������ǰ������У���һ�������������ĸ��ڵ㡣����������У����ĸ��ڵ������е��м䣬
 * �������Ľڵ��ֵλ�ڸ��ڵ����ߣ��������ڵ��ֵλ�ڸ��ڵ�ֵ���ұߡ�
 * 
 * �����Ҫɨ������������в����ҵ�������ֵ���ɴ˿����ҵ��������Ľڵ�ĸ������������ڵ�ĸ�����
 * Ȼ����ǰ������������ҵ��������ĸ��ڵ㣬�ٵ���������������ҵ����������������������������εݹ顣
 * ���ڶ������Ĺ��챾������õݹ�ʵ�ֵģ������ؽ�������Ҳ�õݹ����ʵ��ʵ�ܼ򵥵ġ�
 */
public class BuildBinaryTree {

	public static TreeNode buildTree(String[] preOrder, String[] inOrder) {
		if (preOrder == null || inOrder == null) {
			return null;
		}
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < inOrder.length; i++) {
			map.put(inOrder[i], i);
		}

		return buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, map);

	}

	public static TreeNode buildTree(String[] preOrder, int pstart, int pend, String[] inOrder, int istart, int iend,
			Map<String, Integer> map) {
		if (pstart > pend || istart > iend) {
			return null;
		}
		TreeNode head = new TreeNode(preOrder[pstart]);
		int index = map.get(preOrder[pstart]);

		head.left = buildTree(preOrder, pstart + 1, pstart + index - istart, inOrder, istart, index - 1, map);
		head.right = buildTree(preOrder, pstart + index - istart + 1, pend, inOrder, index + 1, iend, map);

		return head;
	}

	public static void main(String[] args) {
		String[] preOrder = { "A", "B", "D", "H", "I", "E", "J", "C", "F", "K", "G" };
		String[] inOrder = { "H", "D", "I", "B", "E", "J", "A", "F", "K", "C", "G" };

		TreeNode head = buildTree(preOrder, inOrder);
//		// ǰ�����(�ݹ�)
//		System.out.print("ǰ�������");
//		BinaryTreeTraverse.preOrderByRecursion(head);
//		System.out.println();
//
//		// �������(�ݹ�)
//		System.out.print("���������");
//		BinaryTreeTraverse.inOrderByRecursion(head);
//		System.out.println();
//
//		// �������(�ݹ�)
//		System.out.print("���������");
//		BinaryTreeTraverse.postOrderByRecursion(head);
//		System.out.println();
//
//		// ��α���
//		System.out.print("��α�����");
//		BinaryTreeTraverse.layerOrder(head);
	}
}