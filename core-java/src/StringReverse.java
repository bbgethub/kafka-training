public class StringReverse {
        public static void main(String[] args) {
            String str="Java";
            System.out.println("Reversed String is: ");
            System.out.println(reverseString(str));

        }
        public static String reverseString(String str)
        {
            System.out.println("Inside reverseString:"+str);
            char[] ch=str.toCharArray();
            char[] ch1 = new char[str.length()];
            if(str!=null){
                for(int i=str.length()-1,j=0;i>=0;i--,j++)
                {
                    ch1[j]=ch[i];
                }
            }
            return String.valueOf(ch1);
        }
}
