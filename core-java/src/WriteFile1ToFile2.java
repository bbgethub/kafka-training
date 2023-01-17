import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

//Write a Java Program to Read content from one file and writing it into another file
public class WriteFile1ToFile2 {
    public static void main(String args[])
    {
        String s="";
        int i;
        try{
            File file1=new File("C:/genspark/testfile1.txt");
            FileReader reader=new FileReader(file1);
            // Reading the file using read() method which
            // returns -1 at EOF while reading
            while((i=reader.read())!=-1)
            {
                s+=(char)i;
            }
            System.out.println(s);
            FileWriter writer=new FileWriter("C:/genspark/testfile2.txt");
            writer.write(s);
            reader.close();
            writer.close();
            writeFileToFileMethod2();

        }catch(Exception e)
        {
            System.out.println("There are some IOException");
        }
    }
    public static void writeFileToFileMethod2()
    {
        try{
            File f1=new File("C:/genspark/testfile1.txt");
            FileInputStream inputStream=new FileInputStream(f1);
            Scanner sc=new Scanner(inputStream);
            StringBuffer stringBuffer=new StringBuffer();
            while(sc.hasNext())
                stringBuffer.append(" "+sc.nextLine());
            FileWriter fw=new FileWriter("C:/genspark/testfile3.txt");
            fw.write(stringBuffer.toString());
            fw.flush();
            System.out.println("Writing completed");
        }catch(Exception e)
        {

        }
    }
}
