package tree;

/**
 * 给定一棵二叉树，找到该树中两个指定结点的最近公共祖先
 */
public class LowestAncestor {

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// 定义递归终止条件root为null代表未找到，非空代表找到了p或q
		if (root == null || root == p || root == q) {
			return root;
		}
		// 递归左子树结点
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		// 递归右子树结点
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// 左右都非空代表当前root结点就是所需结果
		if (left != null && right != null) {
			return root;
		}
		// 排除为空的一侧
		return left != null ? left : right;
	}

	public static void main(String[] args) {
		TreeNode A = new TreeNode("A");
		TreeNode B = new TreeNode("B");
		TreeNode C = new TreeNode("C");
		TreeNode D = new TreeNode("D");
		TreeNode E = new TreeNode("E");
		TreeNode F = new TreeNode("F");
		TreeNode G = new TreeNode("G");
		TreeNode H = new TreeNode("H");
		TreeNode I = new TreeNode("I");
		TreeNode J = new TreeNode("J");
		TreeNode K = new TreeNode("K");

		A.left = B;
		A.right = C;
		B.left = D;
		B.right = E;
		C.left = F;
		C.right = G;
		D.left = H;
		D.right = I;
		E.right = J;
		F.right = K;

		TreeNode node = lowestCommonAncestor(A, B, F);
		System.out.println(node.value);
	}
}
