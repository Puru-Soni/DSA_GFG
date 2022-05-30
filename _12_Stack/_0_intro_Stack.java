/*
    STACK:
        The Stack is a linear data structure, which follows a particular order in which the operations are performed. 
        The order may be LIFO(Last In First Out) or FILO(First In Last Out).
        The LIFO 
            order says that the element which is inserted at the last in the Stack will be the first one to be removed. 
            In LIFO order, the insertion takes place at the rear end of the stack and deletion occurs at the rear of the stack.
        The FILO 
            order says that the element which is inserted at the first in the Stack will be the last one to be removed. 
            In FILO order, the insertion takes place at the rear end of the stack and deletion occurs at the front of the stack.

    Operations:   
        void Push(Object element): 
            Adds an item in the stack. If the stack is full, then it is said to be an Overflow condition.
        int Pop(): 
            Removes an item from the stack. The items are popped in the reversed order in which they were pushed. 
            If the stack is empty, then it is said to be an Underflow condition.
        int Peek(): 
            Returns the top element of the stack.
        boolean isEmpty(): 
            Returns true if the stack is empty, else false.
        int search(Object element): 
            It determines whether an object exists in the stack. 
            If the element is found, it returns the position of the element from the top of the stack. Else, it returns -1.

    Corner Conditions:
        UnderFlow:
            When pop() or peek() operation is performed on a empty stack. ( Handle it ) 
        OverFlow:
            When push() is called on a full stack. ( no case in dynamic Data Structure )

    Time Complexities: 
        The operations push(), pop(), isEmpty() and peek() all take O(1) time. We do not run any loop in any of these operations.
    
    Implementation: 
        There are two ways to implement a stack.
            Using array
                Pros: Easy to implement. Memory is saved as pointers are not involved.
                Cons: It is not dynamic. It doesn’t grow or shrink depending on needs at runtime.
            
            Using linked list
                Pros: The linked list implementation of stack can either grow or shrink according to the needs at runtime.
                Cons: Requires extra memory due to involvement of pointers.

    Applications:
        Stacks can be used to check for the balancing of paranthesis in an expression.
        Infix to Postfix/Prefix conversion.
        Redo-undo features at many places such as editors, photoshop, etc.
        Forward and backward feature in web browsers.
        And Many More...

        - Function Calls, LIFO order. (most of the programming languages uses stack for funciton calls)
        - Checking for balancing paranthesis
        - reversing items
        - infix to postfix / prefix
        - Evalution of Postfix / Prefix
        - Stock Span probelms
        - Undo / Redo or Forward / Backward


    Stack In Java Collections:
        
        -Java Collection framework provides a Stack class which models and implements the Stack data structure. 
        -The class is based on the basic principle of last-in-first-out. 
        -In addition to the basic push and pop operations, the class provides three more functions of empty, search and peek. 
        -The class can also be said to extend Vector and treats the class as a stack with the five mentioned functions. 
        -The class can also be referred to as the subclass of Vector.
        
        Collections have child list and Queue,
        List has vector parent class and Stack is child Class
        Queue has Deque parent class and ArrayDeque is child class

        We use ArrayDeque for stack implementation in Java Collections.
        Vector is a thread safe, hece has thread safe functionality, and 
        Queue or AarrayDeque is a single-threaded envi. hence vector create extra overhead over Stack.
        
        // Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> s = new ArrayDeque<>();

        operations has time complexity is O(1)

*/