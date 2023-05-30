package hust.soict.dsai.lab01;
// Exercise 6.6
import java.util.*;

public class AddTwoMatrices {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        // Input the matrix size
        System.out.print("Enter the number of rows: ");
        int numRow = scan.nextInt();
        System.out.print("Enter the number of columns: ");
        int numCol = scan.nextInt();
        double[][] a = new double[numRow][numCol];
        double[][] b = new double[numRow][numCol];

        // Input the element of matrix a
        for (int i = 0; i < numRow; i++){
            for (int j = 0; j < numCol; j++){
                System.out.print("a[" + i + "][" + j + "] = ");
                a[i][j] = scan.nextDouble();
            }
        }

        // Input the element of matrix b
        for (int i = 0; i < numRow; i++){
            for (int j = 0; j < numCol; j++){
                System.out.print("a[" + i + "][" + j + "] = ");
                b[i][j] = scan.nextDouble();
            }
        }
        scan.close();

        // Print sum of two matrices
        System.out.println("The sum of two matrices is: ");
        for (int i = 0; i < numRow; i++){
            for (int j = 0; j < numCol; j++){
                double sum = a[i][j] + b[i][j];
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
