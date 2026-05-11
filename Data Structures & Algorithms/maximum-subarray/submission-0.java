class Solution {
    public int maxSubArray(int[] nums) {
        /**
            we keep track of
                currSum
                maxSum

            maxSum is initialized to first element  
            currSum is rolling sum of nums[0..i-1] + nums[i]
                if currSum comes out to be -ve, we reset it to 0, 
                since this is never going to yield a max result
                else 
                    currSum =  nums[0..i-1] + nums[i]
                    maxSum = Math.max(currSum, maxSum)
                
        **/
        if(nums.length == 0){
            return 0;
        }
        int maxSum = nums[0]; //max sum initialized to first element
        int currSum = 0;
        for(int i=0; i<nums.length; i++){
            if(currSum < 0){
                currSum = 0;
            }
            //currSum is rolling sum of previous i-1 elements , if < 0, we reset it to 0
            currSum =nums[i]+currSum;
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
        
    }
}
