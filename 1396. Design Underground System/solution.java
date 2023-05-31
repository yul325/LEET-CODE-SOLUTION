import java.util.*;

class UndergroundSystem implements UndergroundSystemInterface {
    Hashtable<Integer, String> source;
    Hashtable<Integer, Integer> time;
    Hashtable<String, ArrayList<Integer>> allRoute;

    public UndergroundSystem() {
        source = new Hashtable<>();
        time = new Hashtable<>();
        allRoute = new Hashtable<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        time.put(id, t);
        source.put(id, stationName);

    }
    
    public void checkOut(int id, String stationName, int t) {
        String route = source.get(id) + stationName;
        int travelTime = t - time.get(id);
        if(allRoute.get(route) == null){
            ArrayList<Integer> times = new ArrayList<>();
            times.add(travelTime);
            allRoute.put(route, times);
        }
        else{
            allRoute.get(route).add(travelTime);
        }

    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + endStation;
        int size = allRoute.get(route).size();
        double sum = 0;
        ArrayList<Integer> elements = allRoute.get(route);
        for(Integer i : elements){
            sum += i;
        } 
        return sum / size;
    }
}