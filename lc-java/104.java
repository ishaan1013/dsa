class Solution {
  public int maxDepth(TreeNode root) {
    if (root == null)
      return 0;

    int l = maxDepth(root.left);
    int r = maxDepth(root.right);
    // add 1 when both children are 0 (max=0) to represent 1 level of depth
    return Math.max(l, r) + 1;
  }
}