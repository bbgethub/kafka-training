// File Name: SingletonDemo.java
public class SingletonDemo {

    public static void main(String[] args) {
        Singleton tmp = Singleton.getInstance();
        tmp.demoMethod();
        Singleton temp1=Singleton.getInstance();
        temp1.demoMethod();

    }
}