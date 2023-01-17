public class Vehicle {
    int numberOfWheels;
    String brandName,color;
    double price;
    void start(String key)
    {
        System.out.println("Start with "+key);
    }
    void changeGear(String gear){
        System.out.println("It change the by "+ gear);
    }
}
