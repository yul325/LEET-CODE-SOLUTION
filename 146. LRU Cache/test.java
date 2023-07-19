public class test {
    public static void main(String args[]){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1);
        lRUCache.put(2, 2);
        lRUCache.get(2);
        lRUCache.put(1,1);
        lRUCache.put(4, 1);
        lRUCache.get(2);
    }
}
