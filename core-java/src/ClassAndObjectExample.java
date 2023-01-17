public class ClassAndObjectExample {
    public static void main(String args[])
    {
        Vehicle car=new Vehicle();
        car.start("Key");
        car.changeGear("Auto");
        Vehicle bike=new Vehicle();
        bike.start("By kickstart");
        bike.changeGear("handgear");
    }
}

