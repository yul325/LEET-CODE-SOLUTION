public class test {
    public static void main(String args[]){
        UndergroundSystemInterface undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        double a = undergroundSystem.getAverageTime("Paradise", "Cambridge"); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
        double b = undergroundSystem.getAverageTime("Leyton", "Waterloo");
        undergroundSystem.checkIn(10, "Leyton", 24);
        double c = undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);  
        double d = undergroundSystem.getAverageTime("Leyton", "Waterloo");
    }  

}
