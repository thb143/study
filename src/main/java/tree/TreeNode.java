package tree;


/**
 * 定义一个二叉树结点
 * @param <T>
 */
public class TreeNode<T> {
    public T value;
    public TreeNode<T> left;
    public TreeNode<T> right;
 
    public TreeNode(T value) {
        this.value = value;
    }
}