import java.util.Arrays;

public class SwappairsOfChar {
    public static void main(String args[])
    {
        String s1="java";
        System.out.println("Swap pairs of characters: "+swap(s1,0,1));
    }
    public static String swap(String s1,int n1,int n2)
    {
        char ch[]=s1.toCharArray();
        char temp=ch[n1];
        ch[n1]=ch[n2];
        ch[n2]=temp;
        String str=new String(ch);
        return str;
    }
}
