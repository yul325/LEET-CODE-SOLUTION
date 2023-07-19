import java.util.HashMap;

class Node{
    int key;
    int val;
    Node pre;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        pre = null;
        next = null;
    }
}

public class LRUCache {
    HashMap<Integer, Node> hash = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;
    public LRUCache(int capacity) {
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }
    
    public void addNode(Node node){
        Node temp = head.next;

        node.next = temp;
        node.pre = head;
        head.next = node;
        temp.pre = node;
    }

    public void deleteNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public int get(int key) {
        if(hash.containsKey(key)){
            Node curNode = hash.get(key);
            deleteNode(curNode);
            addNode(curNode);
            return curNode.val;
        }
        else 
            return -1;
    }
    
    public void put(int key, int value) {
    
        if(hash.containsKey(key)){
            Node cur = hash.get(key);
            Node node = new Node(key, value);
            hash.put(key, node);
            deleteNode(cur);
            addNode(node);
        }
        //oversize replacement trigger
        else if(hash.size() == capacity){
            Node node = new Node(key, value);
            hash.remove(tail.pre.key);
            deleteNode(tail.pre);
            hash.put(node.key, node);
            addNode(node);
        }
        else{
            Node node = new Node(key, value);
            hash.put(node.key, node);
            addNode(node);
        }
    }
}