public class JunitDemo1 {
    public static void main(String args[])
    {
        System.out.println(method1("Hello"));
    }
    public static String method1(String str1)
    {
        int end=str1.length()-1;
        int start=0;
        char[] charstr=str1.toCharArray();
        while(start<end)
        {
            char temp=charstr[end];
            charstr[end]=charstr[start];
            charstr[start]=temp;
            start++;
            end--;
        }
        return String.valueOf(charstr);
    }
}
