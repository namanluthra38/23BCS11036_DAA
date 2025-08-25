class Stack {
    private int[] stack;
    private int top;
    private int capacity;
    
    // Constructor
    public Stack(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }
    
    
    
    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + element);
            return;
        }
        stack[++top] = element;
        System.out.println("Pushed: " + element);
    }
    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop from empty stack");
            return -1; 
        }
        int element = stack[top--];
        System.out.println("Popped: " + element);
        return element;
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot peek");
            return -1; 
        }
        return stack[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == capacity - 1;
    }
    
    public int size() {
        return top + 1;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack elements (bottom to top): ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
    
    public void clear() {
        top = -1;
        System.out.println("Stack cleared!");
    }
}
public class Main {
    
    
    
    public static void main(String[] args) {
        System.out.println("=== Integer Stack Implementation ===");
        
        Stack stack = new Stack(5);
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        
        stack.push(60);
        
        // Display stack
        stack.display();
        
        System.out.println("Top element: " + stack.peek());
        
        // Test pop operations
        stack.pop();
        stack.pop();
        stack.pop();
        
        stack.display();
        
        
        stack.pop();
        stack.pop();
        
        stack.pop();
        
        
        stack.push(100);
        stack.push(200);
        stack.display();
        stack.display();
        
    }
}
