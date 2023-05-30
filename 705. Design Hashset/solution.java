class MyHashSet {

    /*
    public static void main(String args[]){
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        System.out.println(set.contains(2));
    }*/

    int[] arr;
    public MyHashSet() {
        arr = new int[100];
        for(int i = 0; i < arr.length; i++){
            arr[i] = -1;
        }
    }
    
    public void add(int key) {
        if(contains(key)){
            return;
        }
        else{
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == -1){
                    arr[i] = key;
                    return;
                }
            }
        }
    }
    
    public void remove(int key) {
        if(contains(key)){
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == key)
                    arr[i] = -1;
            }
        }
            
    }
    
    public boolean contains(int key) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == key )
                return true;
        }
        return false;
    }
}
