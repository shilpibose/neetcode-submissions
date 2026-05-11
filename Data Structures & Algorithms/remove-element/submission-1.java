class Solution {
    public int removeElement(int[] nums, int val) {
        int current=0;
        int last = nums.length;

        while(current < last){
            //when current element, is same as val, replace with the last element and decrement
            if(nums[current] == val){
                last --;
                nums[current] = nums[last];
            }else{
                current++;
            }
        }
        return last;
    }
}