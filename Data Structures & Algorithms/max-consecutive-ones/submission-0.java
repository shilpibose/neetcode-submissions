class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int countOnes = 0;
        
        for(int element : nums){
            if(element == 1) {
                countOnes++;
            }else {
                max = Math.max(countOnes, max);
                countOnes = 0;
            }
            
        }
        max = Math.max(countOnes, max);

        return max;
    }
}