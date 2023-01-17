import java.util.Arrays;

public class SortCharInString {
    public static void main(String args[])
    {
        String s1="java";
        char ch[]=s1.toCharArray();
//        Arrays.sort(ch);
//        System.out.println("Using built in sort function:"+ Arrays.toString(ch));
        int l=s1.length();
        for(int i=0;i<l;i++)
            for(int j=i+1;j<l;j++)
            {
                if(ch[i]>ch[j])
                {
                    char temp=ch[i];
                    ch[i]=ch[j];
                    ch[j]=temp;
                }
            }
        System.out.println("Sorted result is: "+ Arrays.toString(ch));
    }
}
