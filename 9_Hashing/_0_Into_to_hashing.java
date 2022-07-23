import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * _0_Into_to_hashing
  
    Hashing is mainly use to implement Dictionaries, where you have key-value pairs.
    Also use to implements Sets, where you have only set of keys.
    Hashing takes O(1) average time to search, insert or delete elements.
    In HasHing or HashTables we always have unquie values no duplicates allowed.
    BUT 
    Hashing is not used for:
        Finding closet values - if key is not present get the min or max than it.
        Sort Data
        prefix Searching
    For this better DS are AVL tree or Red black tree
*/
/* 
    APPLICATION OF HASHING:
    It is the most used DS in CS.
    HashTable is a DS, hashing is a technique

        Implementing Dictionaries
        Database Indexing - Database use indexing to quickly find data.
        CryptoGraphy
        Caches - URL is key and values is storage.
        Symbol Tables in Compliers/Interpretors.
        Routers
        Getting data from databases.
        and many more...
*/
/* 
    DIRECT ADDRESS TABLE
    
    Imagine a situation where you have 1000 keys and values are (0 to 999 )
    implement: Search, Insert, Delete.

    we can use array by creating n sized and use search, insert, delete operations
    but it cannot handle large values or floting point number or keys are string we cant use string as index.
*/
/*
    HASH FUNCTION:

    Direct address table - works only when keys are of small values 
    does not work when keys are large value.
    Hence its a disadvantage.
    
    idea of hashing:
        taking large universe of keys like details....
    use a function called HASHING FUNCTION
    convert this larger keys to smaller...use as an index...called hash table.

    HASH FUNCTION:
        1. For large key we can take module with odd number like 13.
            h(large_key) = large_key % m; (assumed m = 13)
            ( m should be a prime number close to the size of the hash table )
                # But sometimes some elements might have same keys...depending on 'm' this is called collision
        
    HASH TABLE SIZE: depends on how many key are inserted.

        2. For Strings, weighted sum.
            str[] = "abcd"
            str[0]*x^0 + str[1]*x^1 + str[2]*x^2 + ...
*/
/* 
    COLLISION HANDLING:
    In hash fucntion, to map all elements we get keys, taking module with any odd number colse to no of elements.
        Ex: if there are 23 people than there is a 50% chance that 2 of them might have same date of birth,
        or in case of 70 people there is 99.9% chance that 2 of them might have same date of birth this is called
        BirthDay ParaDox. 
    So similarly if in large universe of element there can be collision of keys.

    If we know keys in advance than we use 'Prefect Hashing' which can gaurentee no collisions.
        This is advance method which is not discuss, 
        it is useful while building dicitionaries of all known english words or known things. 
    Else we can use:
        Chaining ( We make a chain of colliding elements )
        Open Addressing ( We use same array, if position is occupied we put that element to other position )
            Linear Probling
            Quadractic  
            Double
*/
/* 
    CHAINING:
        We maintain an array of linked list.
        ex:
            Hash Function -> Hash(key) = key%7
            here, (prime number) m = 7 ( close to 10, size )
            Hash(key) = lets say index.
            i/p keys = {50, 21, 58, 17, 15, 49, 56, 22, 23, 25}

            We store items in: HashTable of Linked List Headers.
            If collision occurs we insert it in end node of Linked list.

            Operation:
                50%7 = 1
                21%7 = 0
                58%7 = 2
                17%7 = 3
                15%7 = 1 (slot  occupied )
                    We add one more node on 1 index linked list.
                49%7 = 0
                56%7 = 0
                22%7 = 0
                23%7 = 2
                25%7 = 4
           
            m = 7
            Bucket = 0 to 7 

            0   --> 21 --> 49 --> 56  (Chain)
            1   --> 50 --> 15 --> 22
            2   --> 58 --> 23
            3   --> 17
            4   --> 25
            5   -->
            6   -->

        Performance of HashTable:
            m = no of slots
            n = no of keys to be inserted
            Load Factor ( alpha ) = n/m
            Expceted Chain Length = alpha
            Time to Search, Insert, Delete = O(1 + alpha)


    Data Strucutre for Storing Chain:
        -Linked List ( Lenght of chain = l | insert, search, delete O(l) )
            Cons: No cache friendly, extra space for storing next node
        -ArrayList ( Search, Insert, Delete - O(l) )
            Pros: cache friendly contingouos mem allocation.
        -Self balancing BST ( operations S,I,D : O(logl) )
            Pros: Java v8+ Self balancing BST is use to store HashMaps.
            Cons: not cache friendly.
*/
/* 
    IMPLEMENTATION OF CHAINING:
        Using Linked List:
        Create an array of linked list.
        If collision occurs we put element in next node.
*/
class MyHash{
    int Bucket;
    ArrayList<LinkedList<Integer>> table;
    MyHash(int b){
        // define size of bucket
        Bucket = b;
        table = new ArrayList<LinkedList<Integer>>();
        for(int i=0; i < b; i++ )
            table.add(new LinkedList<Integer>());
        // Adding empty linked list b times.
    }   
    void insert(Integer key){
        int i = key%Bucket;
        table.get(i).add(key);
    }
    boolean search(Integer key){
        int i = key%Bucket;
        return table.get(i).contains(key);
    }
    void remove(Integer key){
        int i = key&Bucket;
        table.get(i).remove(key);
    }
}

public class _0_Into_to_hashing {

/* 
    HASHSET IN JAVA:
    import java.util.HashSet;

        Hash Set is use to store a set of keys.
        It uses Hashing to store this keys.
        HashTables to store.
        Hash Functions to convert this keys into index in the HashTable.

        Three main operation on HashSet:
            add( o ): o = element. It return true or false if the set is already contain in the HashTable.
            contain( o ): o - is the element whose presence in this set is to be tested. The contains() method returns true if this set contains the specified element.
            remove( o ): o − This is the object to be removed from this set, if present. The method call returns 'true' if the set contained the specified element.

        When we traverse in the Hashset it can iterator randomly.

        HashSet< non-primitive datatype > <name> = new HashSet<>();
        non-primitive datatype:
            Integer, Character, String, Float, Double...
*/

    static void learnHashSet(){
        HashSet<String> hs = new HashSet<>();
        hs.add("gfg"); // adding key
        hs.contains("gfg"); // true

        // To iterator in Collections:
        Iterator<String> it = hs.iterator();
        // run the loop until HashSet contains a element.
        while(it.hasNext()){              
            // it.next() print the element one by one until there are items.
            System.out.println(it.next() + " ");
        }

        // More funtion:
        // Size is used to give size of an set.
        System.out.println(hs.size()); // 1

        hs.add("array");
        System.out.println(hs.size()); // 2

        // Remove function remove the item and return true is item is present in the specified set.
        hs.remove("gfg");

        // Another method to traverse.
        for( String s : hs ){
            System.out.println(s); // [ "array" ]
        }

        // isEmty(): check if the hashSet is empty or not return boolean;
        System.out.println(hs.isEmpty()); // false

        // Clear(): clear all the elements of a hashSet.
        hs.clear();
        System.out.println(hs.isEmpty());  // true
    }

/* 
    HASHMAP IN JAVA:
    import.java.util.HashMap;

        HashSet is use to store only keys but HashMap is use to store key:value pairs.
        HaspMap<String, Integer> hs = new HashMap<>();

        to add pairs:
            hs.put("gfg", 10);
            hs.put("ide", 15);

        print(hs) // { gfg=10, ide=15 };
 
*/

    static void learnhashMap(){
        HashMap<String, Integer> hs = new HashMap<>();
        hs.put("gfg", 10);
        hs.put("ide", 15);
        
        System.out.println(hs);
        System.out.println(hs.size());

        // TO traverse the HashMap.
        for( Map.Entry<String, Integer> e : hs.entrySet() ){
            System.out.println(e.getKey() + " " + e.getValue());
        }
        // It can print in any order.

        // containsKey: use to check if the key is present in the hashmap or not.
        if(hs.containsKey("ide")){
            System.out.println("Yes");
        }

        // remove(key): takes a object - key parameter and remove that map item, (key-value) pair.
        // Return statement: It return the value of which key is removed else null.
        hs.remove("gfg");
        System.out.println(hs.size());

        // containsValue(value) takes value Object to check if the given value exists in the given hashmap or not.
        if(hs.containsValue(15)) System.out.println("Yes");

        // get(key): Takes key Object as parameter and return the corressponding value else null.
        int val = hs.get("ide");
        System.out.println(val); 
    }
    public static void main(String[] args) {
        // learnHashSet();
        learnhashMap();
    }
}