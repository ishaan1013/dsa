class Solution {
  public boolean canJump(int[] nums) {

    int tgt = nums.length - 1;

    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] >= (tgt) - i)
        tgt = i;
      else {
        if (i == 0)
          return false;
      }
    }

    return true;

  }
}