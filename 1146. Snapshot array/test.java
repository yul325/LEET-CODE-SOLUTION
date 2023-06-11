class test{
    public static void main(String args[]){
        solutionInterface snapshotArr = new SnapshotArray(4);
        snapshotArr.snap(); 
        snapshotArr.snap(); 
        snapshotArr.get(3, 1);
        snapshotArr.set(2, 4);
        snapshotArr.snap();
        snapshotArr.set(1, 4); 
    }
}