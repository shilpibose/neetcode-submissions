class Solution {

    
    public int[] replaceElements(int[] arr) {

        
        int rightMax = -1;
        for(int i= arr.length-1; i>=0; i--){
            int max = Math.max(rightMax, arr[i]);
            arr[i]= rightMax;
            rightMax = max;
        }
        return arr;
    }

}