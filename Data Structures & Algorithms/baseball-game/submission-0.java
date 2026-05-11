class Solution {
    /**
        check operation
        - if x - push to stack
             + - x= pop top,  y = pop top , add x+y, push y, push x , push sum
             D - X = pop top, Y= 2*X, push X, push Y
             C - pop top
        iterate through the stack:
            return sum of all elements
    **/
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for(int i =0; i< operations.length; i++) {
            switch(operations[i]){
                case "+":
                    try{
                        applySum(stack);
                    }catch(IllegalArgumentException ex){
                        return 0; //invalid input
                    }
                    break;
                case "D":
                    try{
                        applyDouble(stack);
                    }catch(IllegalArgumentException ex){
                        return 0; //invalid input
                    }
                    break;
                case "C":
                    try{
                        invalidate(stack);
                    }catch(IllegalArgumentException ex){
                        return 0; //invalid input
                    }
                    break;
                default:
                        try{
                            Integer digit = Integer.parseInt(operations[i]);
                            stack.push(digit);
                        }catch(Exception ex){
                            return 0; //invalid input
                        }
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }

    public void applySum(Deque<Integer> stack) throws IllegalArgumentException {
         if(stack.size() < 2){
            //if we dont have enough elements to add, then its invalid input
            throw new IllegalArgumentException("invalid input");
        }

        Integer x = stack.pop();
        Integer y = stack.pop();
        Integer res = x + y;
        stack.push(y);
        stack.push(x);
        stack.push(res);
    }

    public void applyDouble(Deque<Integer> stack) throws IllegalArgumentException {
         if(stack.size() < 1){
            //if we dont have enough elements to add, then its invalid input
            throw new IllegalArgumentException("invalid input");
        }
        Integer x = stack.pop();
        Integer res = 2*x;
        stack.push(x);
        stack.push(res);
    }

    public void invalidate(Deque<Integer> stack) throws IllegalArgumentException {
         if(stack.size() < 1){
            //if we dont have enough elements to add, then its invalid input
            throw new IllegalArgumentException("invalid input");
        }
        stack.pop();
    }
}