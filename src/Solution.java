import java.util.HashMap;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    HashMap<Integer,Integer> dic = new HashMap<>();
    int n = 0;
    int[] pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.pre = preorder;
        for (int i: inorder){
            dic.put(i,n);
            n++;
        }
        return recur(0,0,inorder.length-1) ;
    }

    public  TreeNode recur(int root, int left, int right){
        if(left > right) return null;
        TreeNode node = new TreeNode(pre[root]);
        int i = dic.get(pre[root]);
        node.left = recur(root+1, left, i-1 );
        node.right = recur(root + i - left +1,i+1,right);
        return node;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode treeNode = s.buildTree(pre, in);
    }
}