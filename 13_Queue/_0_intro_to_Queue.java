// /* 
// QUEUE DS:
//     Queue data structure is also know as FIFO first-in_First-out
//     Whatever items comes first they are removes first

//     EX:
//         delete from the queue, dequeue() <- 10   15   20   30   40 <- enqueue(), enter in queue
//                                            front               rear

//     Similar like PIPE, we push something from the rear end of the pipe, 
//     the first item is removed from the front of the pipe first.

//     OPERATION:
//         enqueue() : enter/ insert item from the rear end.
//         dequeue() : delete item from the front side.
//         getFront() : get item in front.
//         getRear() : get item in rear.
//         size() : get size of the queue.
//         isEmpty() : checks if queue is empty return boolean value.
//         isFull() : if Capacity is initialized it check it queue if full or not.
    
// APPLICATION OF QUEUE:
//     - When we have a single costumer and multiple costumers to use that resource we use a queue 
//         Ex: Ticket system, first comes first gets the ticket first.
//         Ex: Process seducling algo: first come first server.
//     - Synchronization between slow and fast devices.
//         Ex: Keyboard is slow and processor is fast, keyboard input is stored in queue and cpu collects all data at once. 
//     - In OS: Semaphores -(sleeping process waiting in queue, when resource is avaiable one of those processor wake up and use it, so they also use a queue),
//         FCFS scheduling, spooling -(like printer, you can print only one resource at a time), buffer for devices like Keyboard. 
//     - In computer Networks (Routers/Switches and mail queues, we have 2 channels slow and fast, we have routers which have queue to slowly synchronize this processes )
//         A server also contains a queue.
//     - Variations: Deque ( Deck = Doubly-ended queue, insert and delete from both the sides ),
//         Priority Queue ( Queue with priority using Heap DS ) and Doubly Ended Priority Queue ( High and Low both priority matters ). 
// */

// // IMPLEMENTATION OF QUEUE USING ARRAY:
// class Queue{
//     int size, capacity;
//     int[] arr;
//     Queue(int cap){
//         capacity = cap;
//         size = 0;
//         arr = new int[capacity];
//     }

//     /*
//         NAIVE IDEA:
//             maintain fornt at index 0 and rear at index size-1; 
//             size = 5
//             arr = []
//             enqueue(10,20,30)
//                 [10 20 30 _ _ ]
//             dequeue(10)
//                 [20 30 _ _ _ ]
//     */
    
//     // O(1)
//     void enqueue(){

//     }

//     // O(n) : we move n-1 items ahead (left side)
//     void dequeue(){

//     }

//     void getFront(){

//     }

//     void getRear(){

//     }

//     boolean isFull(){

//     }

//     boolean ifEmpty(){

//     }

//     int size(){

//     }
// }

// public class _0_intro_to_Queue {

//     public static void main(String[] args) {
        
//     }
// }