package DesignProblem;

import java.util.ArrayList;

public class MinStack {
    public int min;
    public ArrayList<Integer> stack;
    public int top = -1;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new ArrayList<>();
    }

    public void push(int x) {
        if(x<min) min = x;
        stack.add(x);
        top++;
    }

    public void pop() {
        if(top==-1) return;
        boolean flag=false;
        if(stack.get(top)==min)
            flag = true;
        stack.remove(top--);
        if(top==-1){
            min = Integer.MAX_VALUE;
            return;
        }
        if(flag){
            min = stack.get(0);
            for(int i : stack){
                if(i<min)
                    min = i;
            }
        }
    }

    public int top() {
        return stack.get(top);
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}
