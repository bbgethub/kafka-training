public class LinearSearch {
    public static void main (String args[]){
        int a[]=new int[]{10, 20, 44, 77, 91, 50};
        int size = a.length;
        int value = 91,flag=0;

        for (int i=0 ;i< size-1; i++){
            if(a[i]==value){
                System.out.println("Element found index is :"+ i);
                flag=1;
            }
        }
        if(flag==0){
            System.out.println("Element not found");
        }
    }
}
