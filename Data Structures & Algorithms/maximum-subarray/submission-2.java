class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int currSum = 0;
        int maxSum = nums[0];
        int subArrayIndex = 0;

        for(int i=0; i<nums.length; i++){
            if(currSum < 0){
                //reset currSum
                currSum = 0;
            }
            currSum = nums[i] + currSum;
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
