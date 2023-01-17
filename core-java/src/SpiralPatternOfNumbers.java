/*Write a Java Program to Print Spiral Pattern of Numbers*/
public class SpiralPatternOfNumbers {

    public static void main (String args[]){
        int patternMatrixSize = 5;
        int [][] patternMatrix = new int[patternMatrixSize][patternMatrixSize];
        int startingNumber = 1;
        //
        //
        //
        // row index
        int i=0;

        // col index
        int j=0;

        // row index limits
        int m=0;
        int n=patternMatrixSize-1;
        //col index limits
        int p=0;
        int q=patternMatrixSize-1;

        while (startingNumber <= patternMatrixSize*patternMatrixSize){

            for (j=p;j<=q;j++){
                patternMatrix[m][j]=startingNumber;
                startingNumber++;
            }
            m++;
            for (i=m;i<=n;i++){
                patternMatrix[i][q]=startingNumber;
                startingNumber++;
            }
            q--;
            for (j=q;j>=p;j--){
                patternMatrix[n][j]=startingNumber;
                startingNumber++;
            }
            n--;
            for (i=n;i>=m;i-- ){
                patternMatrix[i][p]=startingNumber;
                startingNumber++;
            }
            p++;
        }
        System.out.println("");
        for (i=0;i<patternMatrixSize;i++){
            for (j=0;j<patternMatrixSize;j++){
                System.out.print(patternMatrix[i][j]+"\t");
            }
            System.out.println("");
        }

    }

}
