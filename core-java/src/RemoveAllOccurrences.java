// Write a Java Program to Remove All Occurrences of an Element in an Array
public class RemoveAllOccurrences {
    public static void main(String args[]){
        int array1[]={2,3,4,2,3,5,6};
        int n=array1.length,x=2,j=0;
        for(int i=0;i<n;i++)
        {
            if(array1[i]!=x)
                array1[j++]=array1[i];
        }
        for(int i=0;i<j;i++)
            System.out.print(array1[i]+" ");
    }
}
