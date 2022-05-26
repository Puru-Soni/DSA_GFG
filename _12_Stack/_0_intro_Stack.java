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
        Push: 
            Adds an item in the stack. If the stack is full, then it is said to be an Overflow condition.
        Pop: 
            Removes an item from the stack. The items are popped in the reversed order in which they were pushed. 
            If the stack is empty, then it is said to be an Underflow condition.
        Peek or Top: 
            Returns the top element of the stack.
        isEmpty: 
            Returns true if the stack is empty, else false.

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
*/