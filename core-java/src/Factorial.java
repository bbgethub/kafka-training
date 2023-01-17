/*Write a Java Program to Find Factorial of a number*/
public class Factorial {
    public static void main(String args[]) {
        int n = 5;
        System.out.println("Factorial of " + n + " is : " + factoialrec(n));
    }
    public static int factoialrec(int n)
    {
        if (n == 0 || n == 1)
            return 1;
        else
        return(n*factoialrec(n-1));
    }
}



