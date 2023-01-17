import java.io.File;

public class CompareFilesPath {
    public static void main(String args[])
    {
        File file1=new File("C:/genspark/pic1.jpg");
        File file2=new File("C:/genspark/pic2.jpg");
        if(file1.compareTo(file2)==0)
            System.out.println("Both are same");
        else
            System.out.println("Both are not same");
    }
}
