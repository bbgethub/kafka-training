import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesInArray {
    public static void main(String args[])
    {
        int a1[]={10,20,10,10,30,40,20,30};
        int n=a1.length;
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<n;i++)
            s.add(a1[i]);
        System.out.println("Using Set");
        System.out.println(s);
        for(int i=0;i<n;i++)
        for(int j=i+1;j<n;j++)
        {
            if(a1[i]==a1[j]) {
                a1[j] = a1[n - 1];
                n--;
            }
        }
        System.out.println("With out Set");
        for(int i=0;i<n;i++)
            System.out.print(a1[i]+" ");
    }
}
