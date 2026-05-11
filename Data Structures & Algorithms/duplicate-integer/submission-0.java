class Solution {
    public boolean hasDuplicate(int[] nums) {
        //key num, value : count
       HashMap<Integer,Integer> unique = new HashMap<Integer,Integer>();
       //preprocess
       for(int num : nums){
        if(unique.containsKey(num)){
            int res = unique.put(num,unique.get(num)+1);
        }else{
            unique.put(num, 1);
        }
       } 
       //check duplicates
       for(int value : unique.values()){
        if(value > 1){
            return true;
        }
       }
       return false;
    }
}