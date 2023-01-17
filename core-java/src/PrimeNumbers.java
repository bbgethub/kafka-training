/*Write a Java Program to Display All Prime Numbers from 1 to N*/
public class PrimeNumbers {
    public static void main(String args[])
    {
        int n=14,flag=1;
        for(int i=2;i<=n/2;i++)
        {
            if(n%i==0)
            {
                System.out.println("It's not a prime number"+n);
                flag=0;
                break;
            }
        }
        if(flag==1)
            System.out.println("It's a prime number"+n);
    }
}
