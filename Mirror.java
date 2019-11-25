public class Mirror {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode six = new TreeNode(6);
        TreeNode ten = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        TreeNode eleven = new TreeNode(11);
        root.left = six;
        root.right = ten;
        six.left = five;
        six.right = seven;
        ten.left = nine;
        ten.right = eleven;
        mirror(root);
    }

    private static void mirror(TreeNode root){
        if (root.left!=null)
            mirror(root.left);
        if (root.right!=null)
            mirror(root.right);
        if(root.left!=null||root.right!=null) {
            TreeNode cur = null;
            cur = root.left;
            root.left = root.right;
            root.right = cur;
        }
    }
}
