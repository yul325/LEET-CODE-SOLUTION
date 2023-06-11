import java.util.TreeMap;

class SnapshotArray implements solutionInterface {
    TreeMap<Integer, Integer>[] snapArray;
    int id_tracker = 0;
    public SnapshotArray(int length) {
        snapArray = new TreeMap[length];
        for(int i = 0; i < length; i++){
            snapArray[i] = new TreeMap<>();
            snapArray[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        snapArray[index].put(id_tracker, val);
    }
    
    public int snap() {
        id_tracker++;
        return id_tracker - 1;
    }
    
    public int get(int index, int snap_id) {
        return snapArray[index].floorEntry(snap_id).getValue();
    }
}
