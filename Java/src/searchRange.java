package java;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int s = -1,d = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                if(s == -1) {
                    s = i;
                }
                d = i;
            }
        }

        return new int[]{s,d};
    }

    public static void main(String[] args) {

    }
}
