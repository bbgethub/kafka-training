//Checked Exception Example
public class CheckedExceptionExample {
    public static void main(String args[])
    {
        try{
            Class.forName("ClassName");
        }catch(ClassNotFoundException e)
        {
            System.out.println("ClassNotFoundException"+e);
        }
//Unchecked Exception Example
        int num1=5,num2=0;
        System.out.println(num1/num2);
    }
}
