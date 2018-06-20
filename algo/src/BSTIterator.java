import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        if (root != null) {
            TreeNode p = root;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        }

    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return stack.size() != 0;

    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode curr = stack.pop();
        TreeNode p = curr.right;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        return curr.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        BSTIterator i = new BSTIterator(root);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
