class Solution {
    
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) {
            return 0;
        } else {
            return binSearch(nums, 0, nums.length-1);
        }
    }
    
    public int binSearch(int[] nums, int start, int end) {
        int mid = start  + ((end - start) / 2);
        if(end < start)
            return -1;
    
        int res = -1;
        if(mid == 0 && mid < nums.length) {
           res= nums[mid] > nums[mid+1] ? mid: -1;
        } else if(mid== nums.length-1) {
           res= nums[mid] > nums[mid-1] ? mid: -1;
        } else if(mid > 0 && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
            res = mid;
        } else if(mid < nums.length-1 && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
            res = mid;
        }
        
        if(res == -1) {
            int leftRes = binSearch(nums, start, mid-1);
            if(leftRes == -1) {
                return binSearch(nums, mid+1, end);
            } else {
                return leftRes;
            }
        } else {
            return res;
        }
        
    }
}
