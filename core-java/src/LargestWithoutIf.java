import java.util.Arrays;
import java.util.Scanner;

/* Write a Java Program to Find Largest Among 3 Numbers without using if-else */
public class LargestWithoutIf {
    public static void main(String[] args) {
        int a,b,c,largest,temp;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First Number:");
        a=sc.nextInt();
        System.out.println("Enter Second Number:");
        b=sc.nextInt();
        System.out.println("Enter Third Number");
        c=sc.nextInt();
        temp=a>b?a:b;
        largest=c>temp?c:temp;
        System.out.println("The largets number is: "+largest);
    }
}