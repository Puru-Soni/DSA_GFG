package Linked_list;

import java.util.HashMap;

/* 
    CACHE is a memory which is very close to the cpu.
    Have less access time i.e. it is really fast.
    But small in size compared to RAM.

    For efficient utilization of this memory, LRU is the one of the technique.
    LRU : Least Recently Used.
        Concept is temporal locality: Suppose a item X is now is very likely to be accessed in near future.
        In LRU we keep the recently item accessed in cache,
        and remove the least recent items when we need space in the small size memory i.e. cache 

    Ex:
        cache size = 4
        item: 10 20 10 30 40 50 30 40 60 30

       access 10 - miss         access 20 - miss     access 10 - hit       access 30 - miss    access 40 - miss        
       10 null null null        20 10 null null       10 20 null null      30 10 20 null       40 30 10 20      

        access 50 - miss   access 30 - hit    access 40 - hit    access 60 -miss    access 30- hit
        50 40 30 10        30 50 40 10        40 30 50 10        60 40 30 50        30 60 40 50


        DATA STRUCUTRE THAT CAN SUPPORT THIS TECHNIQUE:

        NAVIE - ARRAYS:
        array of size 4.
        Time complexity of hit and miss Both - O(n)
        Hit - Traverse the complete array to find that element, if found hit, worst case O(n) at last posi.
        Miss - First Traverse the array to find, not found. Move n-1 items to right side and insert the new item in the front.
    
        EFFICIENT - 
        *** IDEA: A data structure that can insert, delete in O(1) time - HashTable or using Hashing. But how to maintain the order.
        Because hashing is unordered *** 
        Hence we Use DOUBLY LINKED LIST WITH HASHING.
        Hashing for quick insert and delete, and Doubly linked list to maintain the order.


        WORKING:

        Initial we have empty cache:
        Access 10 - miss , create a node of doubly linked list -> 10 , create a key value pair in HashTable (10, ref(10));
        Access 20 - miss, create a node, 20 <=> 10, HashTable ->  (20 ,ref(20)), (10, ref(10))
        Access 10 - hit, check in hash, it already exists, no change to hashTabel, List -> 10 <=> 20
        Access 30 - miss, create a node, 30 <=> 10 <=> 20, HashTabel -> (30 , ref(30)), (20, ref(20)), (10, ref(10))
        .
        .
        .
        .
        Access 60 - miss, List -> 60 <=> 40 <=> 30 <=> 50, hashtable => (60, ref(60)), (40, ref(40)), (30, ref(30)), (50, ref(50))
        Access 30 - hit, check in HashTable it exists, List => 30 <=> 60 <=> 40 <=> 50
        
        ALGO:
            Refer(X){
                Look for x in HashTable

                    (a) If found (Hit), find the reference of the node in doubly linked list.
                    Move the node to the front.

                    (b) If not found (Miss), 
                        (i) Insert a new node at the front of the list.
                        (ii) Insert an entry in HashTable.
            }
*/
// class Node { 
// 	int key; 
// 	int value; 
// 	Node pre; 
// 	Node next; 

// 	public Node(int key, int value) 
// 	{ 
// 		this.key = key; 
// 		this.value = value; 
// 	} 
// } 

// class LRUCache { 
// 	private HashMap<Integer, Node> map; 
// 	private int capacity, count; 
// 	private Node head, tail; 

// 	public LRUCache(int capacity) 
// 	{ 
// 		this.capacity = capacity; 
// 		map = new HashMap<>(); 
// 		head = new Node(0, 0); 
// 		tail = new Node(0, 0); 
// 		head.next = tail; 
// 		tail.pre = head; 
// 		head.pre = null; 
// 		tail.next = null; 
// 		count = 0; 
// 	} 

// 	public void deleteNode(Node node) 
// 	{ 
// 		node.pre.next = node.next; 
// 		node.next.pre = node.pre; 
// 	} 

// 	public void addToHead(Node node) 
// 	{ 
// 		node.next = head.next; 
// 		node.next.pre = node; 
// 		node.pre = head; 
// 		head.next = node; 
// 	} 
 
// 	public int get(int key) 
// 	{ 
// 		if (map.get(key) != null) { 
// 			Node node = map.get(key); 
// 			int result = node.value; 
// 			deleteNode(node); 
// 			addToHead(node); 
// 			System.out.println("Got the value : " + 
// 				result + " for the key: " + key); 
// 			return result; 
// 		} 
// 		System.out.println("Did not get any value" + 
// 							" for the key: " + key); 
// 		return -1; 
// 	} 

// 	public void set(int key, int value) 
// 	{ 
// 		System.out.println("Going to set the (key, "+ 
// 			"value) : (" + key + ", " + value + ")"); 
// 		if (map.get(key) != null) { 
// 			Node node = map.get(key); 
// 			node.value = value; 
// 			deleteNode(node); 
// 			addToHead(node); 
// 		} 
// 		else { 
// 			Node node = new Node(key, value); 
// 			map.put(key, node); 
// 			if (count < capacity) { 
// 				count++; 
// 				addToHead(node); 
// 			} 
// 			else { 
// 				map.remove(tail.pre.key); 
// 				deleteNode(tail.pre); 
// 				addToHead(node); 
// 			} 
// 		} 
// 	} 
// } 

// public class _18_LRU_cache {
// 	public static void main(String[] args) { 
		
// 		LRUCache cache = new LRUCache(2); 

// 		// it will store a key (1) with value 
// 		// 10 in the cache. 
// 		cache.set(1, 10); 

// 		// it will store a key (2) with value 20 in the cache. 
// 		cache.set(2, 20); 
// 		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10 

// 		// removing key 2 and store a key (3) with value 30 in the cache. 
// 		cache.set(3, 30); 

// 		System.out.println("Value for the key: 2 is " + cache.get(2)); // returns -1 (not found) 

// 		// removing key 1 and store a key (4) with value 40 in the cache. 
// 		cache.set(4, 40); 
// 		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns -1 (not found) 
// 		System.out.println("Value for the key: 3 is " + cache.get(3)); // returns 30 
// 		System.out.println("Value for the key: 4 is " + cache.get(4)); // return 40 
// 	} 
// }

// ----------------------------------------------------------------------------------------------------------------------------------

class Node {
    Node next;
    Node prev;
    int data;

    Node(int x) {
        data = x;
    }
}

public class _18_LRU_cache {
    public static void main(String[] args) {
        int ar[] = { 10, 20, 10, 30, 40 };
        _getCache(ar);
    }

    public static void _getCache(int[] ar) {
        HashMap<Integer, Node> hm = new HashMap<>();
        Node head = null;
        int cnt = 0;
        for (int i = 0; i < ar.length; i++) {
            if (!hm.containsKey(ar[i])) {
                ++cnt;
                Node temp = new Node(ar[i]);
                hm.put(ar[i], temp);
                temp.next = head;
                if (head != null)
                    head.prev = temp;
                head = temp;
                if (cnt > 2){
                    Node node = _delLast(head);
					hm.remove(node.data);
				}
            } else {
                Node temp = hm.get(ar[i]);
                if (temp.prev != null)
                    temp.prev.next = temp.next;
                if (temp.next != null)
                    temp.next.prev = temp.prev;
                temp.next = head;
                temp.prev = null;
                head = temp;
            }
            printList(head);
            System.out.println("---------------");
        }
    }

    static Node _delLast(Node head) {
        Node curr = head;
        while (curr != null && curr.next != null && curr.next.next != null) {
            curr = curr.next;
        } Node temp = curr.next;
        curr.next = null;
		return temp;
    }

    static void printList(Node head) {
        if (head == null)
            return;
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data + " ");
            curr = curr.next;
        }
    }
}