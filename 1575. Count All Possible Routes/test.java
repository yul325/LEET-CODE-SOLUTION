public class test {
    public static void main(String args[]){
        int[] locations = {1,2,3};
        int start = 0;
        int finish = 2; 
        int fuel = 40;
        solutionInterface solution = new Solution();
        int a = solution.countRoutes(locations, start, finish, fuel);
    }
}
