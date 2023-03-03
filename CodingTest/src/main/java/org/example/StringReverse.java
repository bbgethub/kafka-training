package org.example;

public class StringReverse {
        public static void main(String[] args) {
            String str="Java";
            System.out.println("Reversed String is: ");
            System.out.println(reverseString(str));

        }
        public static String reverseString(String str)
        {

            char[] ch=str.toCharArray();
            char[] ch1=null;
                for(int i=str.length()-1,j=0;i>=0;i--,j++) {
                    ch1[j] = ch[i];
                }

            return String.valueOf(ch1);
        }
}
