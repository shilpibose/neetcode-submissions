class MinStack {
    /***
    Keep one stack to track minimum elements
    and another stack to track stack of elements
    push - 
        check top of minStack, if current element < top of minStack, insert next minimum to min stack
        push to num stack
    pop -
        pop value from num stack, 
        if popped element = top of minstack, pop from minStack too
    getMin
        - peek from minStack
    top
        peek from numStack

    Edge
        - stack empty , minStack empty


    **/
    Deque<Integer> minStack;
    Deque<Integer> nums;
    public MinStack() {
        minStack = new ArrayDeque<>();
        nums = new ArrayDeque<>();
    }
    
    public void push(int val) {
        nums.push(val);
        if(!minStack.isEmpty()){
            int currMin = minStack.peek();
            if(val <= currMin){
                minStack.push(val);
            }
        }else{
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val = nums.pop();
        int currMin = minStack.peek();
        if(val == currMin){
            minStack.pop();
        }
        
    }
    
    public int top() {
        return  nums.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
