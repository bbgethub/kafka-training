/*Write a Java Program For Binary to Decimal Conversion*/
public class BinaryToDecimal {
    public static void main(String args[])
    {
        long num=101,remainder;
        System.out.println("Binary Number is: "+num);
        int decimalnum=0,i=0;
        while(num!=0)
        {
            remainder=num%10;
            num/=10;
            decimalnum+=remainder*Math.pow(2,i);
            ++i;
        }
        System.out.println("Decimal number is: "+decimalnum);
    }
}
